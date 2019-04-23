package ru.itis.services;

import ru.itis.models.Card;
import ru.itis.models.Task;

import java.util.List;

public interface TaskService {
    List<Task> findCardTasks(Card card);
}
