package ru.itis.services;

import ru.itis.models.Card;
import ru.itis.models.Task;
import ru.itis.models.User;
import ru.itis.transfer.UserDto;

import java.util.List;
import java.util.Optional;

public interface CardService {
    List<Card> findDeskCards(Long id);

    Optional<Card> findById(Long cardId);

    List<Card> findAll();
}
