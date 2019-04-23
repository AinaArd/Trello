package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Card;
import ru.itis.models.Task;

import java.util.List;

public interface TasksRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByCard(Card card);
}
