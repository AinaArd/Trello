package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itis.models.Card;
import ru.itis.models.User;
import ru.itis.services.CardServiceImpl;
import ru.itis.services.UserServiceImpl;

import java.util.List;
import java.util.Optional;

@Controller
public class UsersController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private CardServiceImpl cardService;

    @RequestMapping(method = RequestMethod.GET, path = "/users")
    public String getUsers(ModelMap model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @RequestMapping(path = "/users/{user-id}", method = RequestMethod.GET)
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

    /*@ResponseBody
    @RequestMapping("/string")
    public String showString(){
        return "Aina";
    }*/

}
