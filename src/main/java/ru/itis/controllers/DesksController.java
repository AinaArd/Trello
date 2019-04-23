package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.models.Card;
import ru.itis.models.Desk;
import ru.itis.security.details.UserDetailsImpl;
import ru.itis.services.CardService;
import ru.itis.services.DeskService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class DesksController {

    @Autowired
    private DeskService deskService;

    @Autowired
    private CardService cardService;

    @GetMapping(path = "/desks")
    public String getLoginPage(Authentication authentication, ModelMap model) {
        if (authentication == null) {
            return "redirect:login";
        }
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        Long userId = details.getUser().getId();

        List<Desk> desks = deskService.findAllUserDesks(userId);
        model.addAttribute("desks", desks);
        return "desks";
    }

    @GetMapping(path = "/desks/{desk-id}")
    public String getOneDesk(ModelMap model, @PathVariable(name = "desk-id") Long deskId) {
        if(deskService.findOneDesk(deskId).isPresent()) {
            Desk selectedDesk = deskService.findOneDesk(deskId).get();

            List<Card> deskCards = cardService.findDeskCards(selectedDesk.getId());

            model.addAttribute("cards", deskCards);
            model.addAttribute("desks", Collections.singletonList(selectedDesk));
        }
        return "desks";
    }
}
