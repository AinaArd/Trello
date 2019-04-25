package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.forms.EditForm;
import ru.itis.services.UserServiceImpl;

@Controller
public class EditController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(path = "/edit")
    public String getEditPage(){
        return "edit";
    }

    @PostMapping(path = "/edit")
    public String editUserProfile(Authentication authentication, EditForm editForm) {
        System.out.println(editForm.getLogin());

        userService.saveAndFlush(editForm, authentication);
        return "redirect:profile";
    }
}
