package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.forms.RegisterForm;
import ru.itis.services.UserService;

@Controller
@RequestMapping
public class RegisterController {

    private UserService service;

    @Autowired
    public RegisterController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public String register(/*@Valid */RegisterForm registerForm, BindingResult bindingResult, ModelMap model) {
       /* if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult
                    .getFieldErrors()
                    .stream()
                    .map(error -> error.getField() + ": " + error.getDefaultMessage()).collect(Collectors.toList());
            model.addAttribute("errors", errors);
        }*/
        service.register(registerForm);
        return "redirect:login";
    }

    @GetMapping("/register")
    public String showPage(){
        return "register";
    }
}
