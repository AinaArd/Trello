package ru.itis.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.transfer.UserDto;
import ru.itis.security.details.UserDetailsImpl;

import static ru.itis.transfer.UserDto.from;

@Controller
public class ProfileController {

    @RequestMapping(path = "/profile", method = RequestMethod.GET)
    public String getUserPage(ModelMap model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:login";
        }
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        UserDto user = from(details.getUser());
        model.addAttribute("user", user);
        return "profile";
    }

}
