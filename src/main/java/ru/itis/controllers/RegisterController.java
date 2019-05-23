package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.forms.RegisterForm;
import ru.itis.services.RegisterService;

import javax.validation.Valid;

@Controller
@RequestMapping
public class RegisterController {

    @Autowired
    private RegisterService service;

    @PostMapping("/register")
    public String register(@Valid RegisterForm registerForm) {
        service.register(registerForm);
        return "redirect:login";
    }

    @GetMapping("/register")
    public String showPage(){
        return "register";
    }
}
