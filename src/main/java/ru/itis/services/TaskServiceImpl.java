package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.models.Card;
import ru.itis.models.Task;
import ru.itis.repositories.TasksRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TasksRepository tasksRepository;

    @Override
    public List<Task> findCardTasks(Card card) {
        return tasksRepository.findAllByCard(card);
    }

    @Override
    public Optional<Task> findTaskById(Long id) {
        return tasksRepository.findById(id);
    }


}
