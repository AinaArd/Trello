package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.forms.DeskForm;
import ru.itis.models.*;
import ru.itis.security.details.UserDetailsImpl;
import ru.itis.services.CardService;
import ru.itis.services.DeskService;
import ru.itis.services.TaskService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class DesksController {

    @Autowired
    private DeskService deskService;

    @Autowired
    private CardService cardService;

    @Autowired
    private TaskService taskService;

    @GetMapping(path = "/desks")
    public String getLoginPage(Authentication authentication, ModelMap model) {
        if (authentication == null) {
            return "redirect:login";
        }
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        Long userId = details.getUser().getId();

        List<Desk> desks = deskService.findAllUserDesks(userId);
        model.addAttribute("flag", true);
        model.addAttribute("desks", desks);
        return "desks";
    }

    @GetMapping(path = "/desks/{desk-id}")
    public String getOneDesk(ModelMap model, @PathVariable(name = "desk-id") Long deskId) {
        if (deskService.findOneDesk(deskId).isPresent()) {
            Desk selectedDesk = deskService.findOneDesk(deskId).get();
            List<Card> deskCards = cardService.findDeskCards(selectedDesk.getId());
            model.addAttribute("cards", deskCards);
            model.addAttribute("desks", Collections.singletonList(selectedDesk));
        }
        return "desks";
    }

//    TODO: make desk add
    @PostMapping(path = "/desks", params = {"name", "state"})
    public String addDesk(ModelMap model, DeskForm deskForm, Authentication authentication, @RequestParam(name = "name") String name,
                          @RequestParam(name = "state") String state) {

        DeskState deskState = DeskState.valueOf(state);
//        TODO: fix error with DeskForm
       /* Desk desk = Desk.builder()
                .name(deskForm.getDeskName())
                .state(state).build();*/
        Desk desk = Desk.builder()
                .name(name)
                .state(deskState)
                .build();

        User owner = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        deskService.addDeskOwner(desk, owner);
        return "redirect:desks";
    }
}
