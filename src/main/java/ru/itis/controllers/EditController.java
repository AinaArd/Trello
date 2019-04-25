package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.forms.EditForm;
import ru.itis.services.UserServiceImpl;

@Controller
public class EditController {

    @Autowired
    private UserServiceImpl userService;

//    TODO: button in profile->edit page
    @GetMapping(path = "/edit")
    public String getEditPage(){
        return "edit";
    }

    @PostMapping(path = "/edit")
    public String editUserProfile(Authentication authentication, EditForm editForm) {
        System.out.println(editForm);
        if(userService.checkLoginAndPassword(editForm)) {
            userService.saveAndFlush(editForm, authentication);
            return "redirect:profile";
        }
        return "redirect:edit";
    }
}
