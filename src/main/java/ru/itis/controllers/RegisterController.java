package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import ru.itis.forms.RegisterForm;
import ru.itis.services.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping
public class RegisterController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public String register(@Valid RegisterForm registerForm, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult
                    .getFieldErrors()
                    .stream()
                    .map(error -> error.getField() + ": " + error.getDefaultMessage()).collect(Collectors.toList());
            System.out.println(errors);
            model.addAttribute("errors", errors);
            return "register";
        } else {
            service.register(registerForm);
        }
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String showPage() {
        return "register";
    }
}
