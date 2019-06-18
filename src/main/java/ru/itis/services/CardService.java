package ru.itis.services;

import ru.itis.models.Card;
import ru.itis.transfer.CardDto;

import java.util.List;
import java.util.Optional;

public interface CardService {
    List<Card> findDeskCards(Long id);

    Optional<Card> findById(Long cardId);

    List<Card> findAll();

    void addCard(Card newCard);

    CardDto editCardName(Card card);


}
