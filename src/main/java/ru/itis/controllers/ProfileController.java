package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.models.Card;
import ru.itis.models.User;
import ru.itis.services.CardServiceImpl;
import ru.itis.services.UserServiceImpl;

import java.util.List;
import java.util.Optional;

@Controller
public class ProfileController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private CardServiceImpl cardService;

    @RequestMapping(path = "/profile/{user-id}", method = RequestMethod.GET)
    public String getUserPage(ModelMap model, @PathVariable(name = "user-id") Long userId) {
        Optional<User> userCandidate = userService.findById(userId);

        if(userCandidate.isPresent()) {
            User user = userCandidate.get();
            List<Card> cards = cardService.findAllByMember(user);
            model.addAttribute("user", user);
            model.addAttribute("cards", cards);
        }
        return "profile";
    }

}
