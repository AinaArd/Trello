package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.forms.UserForm;
import ru.itis.models.User;
import ru.itis.services.UserServiceImpl;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(path = "/login")
    public String getLoginPage(){
        return "login";
    }

    @PostMapping(path = "/login")
    public String sendToProfile(UserForm userForm){
        Optional<User> userCandidate = userService.findByLoginAndPassword(userForm);
        return userCandidate.map(user -> "redirect:profile/" + user.getId()).orElse("redirect:login");
    }

}
