package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.forms.EditForm;
import ru.itis.transfer.UserDto;
import ru.itis.security.details.UserDetailsImpl;
import ru.itis.services.UserServiceImpl;

import java.security.Principal;

import static ru.itis.transfer.UserDto.from;

@Controller
public class ProfileController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(path = "/profile", method = RequestMethod.GET)
    public String getUserPage(ModelMap model, Authentication authentication, Principal principal) {
        if (authentication == null) {
            return "redirect:login";
        }
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        UserDto user = from(details.getUser());
        model.addAttribute("user", user);
        return "profile";
    }

    @RequestMapping(path = "/profile", method = RequestMethod.POST, params = {"name", "login", "password"})
    public String editUserProfile(Authentication authentication, EditForm editForm) {
        userService.saveAndFlush(editForm, authentication);
        return "redirect:profile";
    }
}
