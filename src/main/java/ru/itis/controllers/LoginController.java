package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.services.UserServiceImpl;


@Controller
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(path = "/login")
    public String getLoginPage(){
        return "login";
    }
}
