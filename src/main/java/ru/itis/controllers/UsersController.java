package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;
import ru.itis.services.UserServiceImpl;

import java.util.List;

@Controller
@RequestMapping(path = "/users")
public class UsersController {

    @Autowired
    private UserServiceImpl service;

    @GetMapping
    public String getUsers(ModelMap model){
        model.addAttribute("users", service.findAll());
        return "users";
    }

    /*@ResponseBody
    @RequestMapping("/string")
    public String showString(){
        return "Aina";
    }*/

}
