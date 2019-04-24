package ru.itis.services;

import ru.itis.models.Card;
import ru.itis.models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> findCardTasks(Card card);
    Optional<Task> findTaskById(Long id);
}
