package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.forms.UserForm;
import ru.itis.services.UserService;

@Controller
@RequestMapping
public class RegisterController {

    @Autowired
    private UserService service;

    /*@RequestMapping(params = {"name", "login", "password"}, method = RequestMethod.POST)
    public String registerUser(@RequestParam(name = "name") String name, @RequestParam(name = "email") String login,
                          @RequestParam(name = "password") String password) {
        User newUser = new User(name, login, password);
        System.out.println(newUser);
        usersRepository.save(newUser);
        return "redirect:users";
    }*/

    @PostMapping("/register")
    public String register(UserForm userForm) {
        service.register(userForm);
        return "redirect:login";
    }

    @GetMapping("/register")
    public String showPage(){
        return "register";
    }
}
