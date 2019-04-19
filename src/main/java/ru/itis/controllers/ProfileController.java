package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.models.Card;
import ru.itis.models.User;
import ru.itis.forms.EditForm;
import ru.itis.transfer.UserDto;
import ru.itis.security.details.UserDetailsImpl;
import ru.itis.services.CardServiceImpl;
import ru.itis.services.UserServiceImpl;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import static ru.itis.transfer.UserDto.from;

@Controller
public class ProfileController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private CardServiceImpl cardService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(path = "/profile", method = RequestMethod.GET)
    public String getUserPage(ModelMap model, Authentication authentication, Principal principal) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String login = auth.getName();
//        Optional<User> userCandidate = userService.findByLogin(login);
//
//        if(userCandidate.isPresent()) {
//            User user = userCandidate.get();
//            List<Card> cards = cardService.findAllByMember(user);
//            model.addAttribute("user", user);
//            model.addAttribute("cards", cards);
//        }
//        return "profile";
        if (authentication == null) {
            return "redirect:login";
        }
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        UserDto user = from(details.getUser());
        List<Card> cards = cardService.getCards(user);
        model.addAttribute("user", user);
        model.addAttribute("cards", cards);
        return "profile";
    }

//    TODO: make post method with editform
//    @RequestMapping(path = "/profile", method = RequestMethod.POST)
//    public String editUserProfile(EditForm editForm) {
//        User editedUser = User.from(editForm);
//        System.out.println(editedUser);
//        userService.saveAndFlush(editedUser);
//        return "redirect:profile";
//    }

    @RequestMapping(path = "/profile", method = RequestMethod.POST, params = {"name", "login", "password"})
    public String editUserProfile(Authentication authentication, @RequestParam(name = "name") String name, @RequestParam(name = "login") String login,
                                  @RequestParam(name = "password") String password) {
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        Long userId = details.getUser().getId();
        System.out.println(userId);
        details.getUser().setName(name);
        details.getUser().setLogin(login);
        details.getUser().setHashPassword(password);
        userService.saveAndFlush(details.getUser());
//        userService.editUser(name, login, passwordEncoder.encode(password), userId);

        return "redirect:profile";
    }
}
