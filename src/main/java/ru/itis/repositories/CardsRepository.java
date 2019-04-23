package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.models.Card;

import java.util.List;
import java.util.Optional;

public interface CardsRepository extends JpaRepository<Card, Long> {

    @Query(nativeQuery = true, value = "select * from card inner join desk d on card.desk_cards = d.id where d.id=?")
    List<Card> findAllByDesk_cards(Long deskId);

    @Override
    Optional<Card> findById(Long aLong);
}
