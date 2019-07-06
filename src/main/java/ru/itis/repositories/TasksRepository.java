package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.models.Card;
import ru.itis.models.Task;
import ru.itis.models.User;

import java.util.List;
import java.util.Optional;

public interface TasksRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByCardOrderByText(Card card);

    @Override
    <S extends Task> S save(S s);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from user_tasks where tasks_id = ?")
    void deleteTask(Long taskId);

    @Query(nativeQuery = true, value = "select * from task where name=?")
    Optional<Task> findByName(String name);
}
