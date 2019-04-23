package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.models.Card;
import ru.itis.models.Task;
import ru.itis.services.CardService;
import ru.itis.services.TaskService;

import java.util.List;

@Controller
public class CardsController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private CardService cardService;

    @GetMapping(path = "/cards")
    public String getAllCards(ModelMap model){
        List<Card> cards = cardService.findAll();
        model.addAttribute("cards", cards);
        return "cards";

    }

    @GetMapping(path = "/cards/{card-id}")
    public String showCard(ModelMap model, @PathVariable(name = "card-id") Long cardId) {
        if(cardService.findById(cardId).isPresent()) {
            Card selectedCard = cardService.findById(cardId).get();
            List<Task> cardTasks = taskService.findCardTasks(selectedCard);
            System.out.println(cardTasks);
            model.addAttribute("tasks", cardTasks);
        }
        return "tasks";
    }
}
