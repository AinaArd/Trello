package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    private TaskService taskService;

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

    @RequestMapping(path = "/profile/{user-id}", method = RequestMethod.GET)
    public String getAnotherUserPage(@PathVariable(name = "user-id") Long userId, Authentication authentication, ModelMap model) {
        User currentUser = ((UserDetailsImpl) authentication.getPrincipal()).getUser();

        if (userService.findById(userId).isPresent()) {
            User otherUser = userService.findById(userId).get();

            if(!otherUser.getId().equals(currentUser.getId())){
                model.addAttribute("user", otherUser);
                return "anotherUserProfile";
            }
        }
//        TODO: no such user!
        model.addAttribute("flag", true);
        return "profile";
    }

}
