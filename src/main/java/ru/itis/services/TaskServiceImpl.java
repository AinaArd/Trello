package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.forms.TaskEditForm;
import ru.itis.models.Card;
import ru.itis.models.Comment;
import ru.itis.models.Task;
import ru.itis.models.TaskState;
import ru.itis.repositories.CommentRepository;
import ru.itis.repositories.TasksRepository;
import ru.itis.transfer.TaskDto;
import ru.itis.utils.FileDownloader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ru.itis.transfer.TaskDto.from;

@Service
public class TaskServiceImpl implements TaskService {

    private FileDownloader fileDownloader;

    private TasksRepository tasksRepository;

    private CommentRepository commentsRepository;

    @Autowired
    public TaskServiceImpl(FileDownloader fileDownloader, TasksRepository tasksRepository, CommentRepository commentsRepository) {
        this.fileDownloader = fileDownloader;
        this.tasksRepository = tasksRepository;
        this.commentsRepository = commentsRepository;
    }

    @Override
    public List<Task> findCardTasks(Card card) {
        return tasksRepository.findAllByCardOrderByText(card);
    }

    @Override
    public Optional<Task> findTaskById(Long id) {
        return tasksRepository.findById(id);
    }

    @Override
    public TaskDto addTask(Task task) {
        TaskDto newTask = from(tasksRepository.save(task));
        return newTask;
    }

    @Override
    public List<List<Task>> findAllTasksInAllCards(List<Card> cards) {
        List<List<Task>> tasks = new ArrayList<>();
        for (Card card : cards) {
            tasks.add(findCardTasks(card));
        }
        return tasks;
    }

    @Override
    public void edit(String name, String text, String state,
                     MultipartFile file, Task task) {
        String photoPath = fileDownloader.upload(file, name).orElseThrow(IllegalArgumentException::new);
        if (!text.equals("") || !name.equals("")) {
            task.setName(name);
            task.setText(text);
            task.setState(TaskState.valueOf(state));
            task.setPicturePath(photoPath);
            tasksRepository.saveAndFlush(task);
        }
    }

    @Override
    public void addText(TaskEditForm taskEditForm, Task task) {
        task.setText(taskEditForm.getText());
        tasksRepository.saveAndFlush(task);
    }

    @Override
    public void archive(Task task) {
        task.setFlag(true);
        tasksRepository.saveAndFlush(task);
    }

    @Override
    public Comment addComment(Comment comment) {
        return commentsRepository.save(comment);
    }

    @Override
    public void changeFlag(Task task) {
        task.setFlag(false);
        tasksRepository.save(task);
    }

    @Override
    public void deleteTask(Task task) {
        tasksRepository.delete(task);
        tasksRepository.deleteTask(task.getId());
    }

}
