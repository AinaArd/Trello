package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.models.Card;
import ru.itis.models.User;

import java.util.List;

public interface CardsRepository extends JpaRepository<Card, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM card inner join card_card_members m " +
            "on card.id = m.cards_id where m.card_members_id = ?")
    List<Card> findAllByMember(Long userId);


}
