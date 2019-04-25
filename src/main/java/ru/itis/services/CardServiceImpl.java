package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.models.Card;
import ru.itis.models.Task;
import ru.itis.models.User;
import ru.itis.repositories.CardsRepository;
import ru.itis.transfer.UserDto;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardsRepository cardsRepository;


    @Override
    public List<Card> findDeskCards(Long id) {
        return cardsRepository.findAllByDesk_cards(id);
    }



    @Override
    public Optional<Card> findById(Long cardId) {
        return cardsRepository.findById(cardId);
    }

    @Override
    public List<Card> findAll() {
        return cardsRepository.findAll();
    }
}
