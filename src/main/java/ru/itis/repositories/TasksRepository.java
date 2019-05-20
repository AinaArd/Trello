package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.models.Card;
import ru.itis.models.Task;
import ru.itis.models.User;

import java.util.List;

public interface TasksRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByCardOrderByText(Card card);

    @Override
    <S extends Task> S save(S s);
}
