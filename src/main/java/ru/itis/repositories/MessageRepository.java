package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.itis.models.Desk;
import ru.itis.models.Message;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    @Query(nativeQuery = true, value = "select * from message inner join \"user\" u on message.sender = u.id where u.id = ?")
    List<Message> getAllByUser(Long userId);

    List<Message> findAllByDesk(Desk desk);
}
