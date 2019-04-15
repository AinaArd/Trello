package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Card;

public interface CardsRepository extends JpaRepository<Card, Long> {
}
