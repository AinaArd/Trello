package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itis.forms.UserEditForm;
import ru.itis.models.Card;
import ru.itis.models.Task;
import ru.itis.models.User;
import ru.itis.services.TaskService;
import ru.itis.services.UserService;
import ru.itis.transfer.UserDto;
import ru.itis.security.details.UserDetailsImpl;

import java.util.List;

import static ru.itis.transfer.UserDto.from;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/profile")
    public String getUserPage(ModelMap model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:login";
        }
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        UserDto user = from(details.getUser());
        int desksNumber = details.getUser().desksNumber();
        int tasksNumber = details.getUser().tasksNumber();
        int commentsNumber = details.getUser().commentsNumber();
        model.addAttribute("user", user);
        model.addAttribute("desksNumber", desksNumber);
        model.addAttribute("tasksNumber", tasksNumber);
        model.addAttribute("commentsNumber", commentsNumber);
        return "profile";
    }

    @GetMapping(path = "/profile/{user-id}")
    public String getAnotherUserPage(@PathVariable(name = "user-id") Long userId, Authentication authentication, ModelMap model) {
        User currentUser = ((UserDetailsImpl) authentication.getPrincipal()).getUser();

        if (userService.findById(userId).isPresent()) {
            User otherUser = userService.findById(userId).get();

            if (!otherUser.getId().equals(currentUser.getId())) {
                model.addAttribute("user", otherUser);
                return "anotherUserProfile";
            }
        }
        model.addAttribute("flag", true);
        return "profile";
    }

}
