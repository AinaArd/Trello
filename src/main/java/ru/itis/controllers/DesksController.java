package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.forms.CardForm;
import ru.itis.forms.DeskForm;
import ru.itis.forms.TaskForm;
import ru.itis.models.*;
import ru.itis.security.details.UserDetailsImpl;
import ru.itis.services.CardService;
import ru.itis.services.DeskService;
import ru.itis.services.TaskService;
import ru.itis.services.UserService;

import java.util.List;

@Controller
public class DesksController {

    @Autowired
    private DeskService deskService;

    @Autowired
    private CardService cardService;

    @Autowired
    private UserService userService;


    @GetMapping(path = "/desks")
    public String getLoginPage(Authentication authentication, ModelMap model) {
        if (authentication == null) {
            return "redirect:login";
        }
        User user = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        Long id = user.getId();
        if (userService.findById(id).isPresent()) {
            user = userService.findById(id).get();
        }
        model.addAttribute("addDesk", true);
        model.addAttribute("userDesks", user);
        return "desks";
    }

    @GetMapping(path = "/desks/{desk-id}")
    public String getOneDesk(ModelMap model, @PathVariable(name = "desk-id") Long deskId) {
        if (deskService.findOneDesk(deskId).isPresent()) {
            Desk selectedDesk = deskService.findOneDesk(deskId).get();
            List<Card> deskCards = cardService.findDeskCards(selectedDesk.getId());
            model.addAttribute("selectedDesk", selectedDesk);
            model.addAttribute("addCard", true);
            model.addAttribute("cards", deskCards);
        }
        return "desks";
    }
//


//    @PostMapping(path = "/desks/{desk-id}")
//    public String addCard(CardForm cardForm, @PathVariable(name = "desk-id") Long deskId) {
//        if (deskService.findOneDesk(deskId).isPresent()) {
//            Desk desk = deskService.findOneDesk(deskId).get();
//            Card newCard = Card.builder()
//                    .name(cardForm.getName())
//                    .desk(desk)
//                    .build();
//            cardService.addCard(newCard);
//        }
//        return "redirect:{desk-id}";
//    }

    @PostMapping("/desks")
    public String showOtherUserPage(@RequestParam(name = "userName") String userName, ModelMap model) {
        if (!userName.equals("")) {
            User userCandidate = userService.findByLogin(userName).orElseThrow(IllegalArgumentException::new);
            model.addAttribute("user", userCandidate);
        }
        return "redirect:profile/{user-id}";
    }

    @PostMapping(value = "/desks", params = "save")
    public String addDesk(DeskForm deskForm, Authentication authentication) {
        User deskOwner = ((UserDetailsImpl)authentication.getPrincipal()).getUser();
        Desk newDesk = Desk.builder()
                .name(deskForm.getName())
                .state(DeskState.valueOf(deskForm.getState()))
                .owner(deskOwner)
                .build();
        deskService.addDesk(newDesk);
        return "redirect:desks";
    }
}
