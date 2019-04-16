package ru.itis.services;

import ru.itis.models.Card;
import ru.itis.models.User;

import java.util.List;

public interface CardService {
    List<Card> findAllByMember(User user);
}
