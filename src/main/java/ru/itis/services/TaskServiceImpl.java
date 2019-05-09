package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.forms.TaskEditForm;
import ru.itis.models.Card;
import ru.itis.models.Comment;
import ru.itis.models.Task;
import ru.itis.models.TaskState;
import ru.itis.repositories.CardsRepository;
import ru.itis.repositories.CommentRepository;
import ru.itis.repositories.TasksRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TasksRepository tasksRepository;

    @Autowired
    private CommentRepository commentsRepository;

    @Override
    public List<Task> findCardTasks(Card card) {
        return tasksRepository.findAllByCardOrderByText(card);
    }

    @Override
    public Optional<Task> findTaskById(Long id) {
        return tasksRepository.findById(id);
    }

    @Override
    public Task addTask(Task task) {
        return tasksRepository.save(task);
    }

    @Override
    public List<List<Task>> findAllTasksInAllCards(List<Card> cards) {
        List<List<Task>> tasks = new ArrayList<>();
        for(Card card : cards) {
            tasks.add(findCardTasks(card));
        }
        return tasks;
    }

    @Override
    public void edit(TaskEditForm taskEditForm, Task task) {
        task.setName(taskEditForm.getName());
        task.setText(taskEditForm.getText());
        task.setState(TaskState.valueOf(taskEditForm.getState()));
        tasksRepository.saveAndFlush(task);
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
//        TODO: hide task from the screen
    }

    @Override
    public Comment addComment(Comment comment) {
        return commentsRepository.save(comment);
    }
}
