package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.forms.EditForm;
import ru.itis.models.User;
import ru.itis.security.details.UserDetailsImpl;
import ru.itis.services.UserServiceImpl;

@Controller
public class EditController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(path = "/edit")
    public String getEditPage(Authentication authentication, ModelMap model) {
        User currentUser = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        model.addAttribute("user", currentUser);
        return "edit";
    }

    @PostMapping(path = "/edit")
    public String editUserProfile(Authentication authentication, EditForm editForm) {
        if (userService.checkLoginAndPassword(editForm)) {
            userService.saveAndFlush(editForm, authentication);
            return "redirect:profile";
        }
        return "redirect:edit";
    }
}
