package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.models.Card;
import ru.itis.models.User;
import ru.itis.repositories.CardsRepository;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardsRepository cardsRepository;

    @Override
    public List<Card> findAllByMember(User user) {
        return cardsRepository.findAllByMember(user.getId());
    }
}
