package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.models.Card;
import ru.itis.repositories.CardsRepository;
import ru.itis.transfer.CardDto;

import java.util.List;
import java.util.Optional;

import static ru.itis.transfer.CardDto.from;

@Service
public class CardServiceImpl implements CardService {

    private CardsRepository cardsRepository;

    @Autowired
    public CardServiceImpl(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
    }

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

    @Override
    public void addCard(Card newCard) {
        cardsRepository.save(newCard);
    }

    @Override
    public CardDto edit(Card card) {
        CardDto dto = from(cardsRepository.saveAndFlush(card));
        return dto;
    }
}
