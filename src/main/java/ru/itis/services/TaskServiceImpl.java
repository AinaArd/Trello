package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.forms.TaskEditForm;
import ru.itis.models.Card;
import ru.itis.models.Task;
import ru.itis.models.User;
import ru.itis.repositories.TasksRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TasksRepository tasksRepository;

    @Override
    public List<Task> findCardTasks(Card card) {
        return tasksRepository.findAllByCardOrderByText(card);
    }

    @Override
    public Optional<Task> findTaskById(Long id) {
        return tasksRepository.findById(id);
    }

    @Override
    public void addTask(Task task) {
        tasksRepository.save(task);
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
        tasksRepository.saveAndFlush(task);
    }

    @Override
    public void addText(TaskEditForm taskEditForm, Task task) {
        System.out.println(taskEditForm.getText());
        task.setText(taskEditForm.getText());
        tasksRepository.saveAndFlush(task);
    }

}
