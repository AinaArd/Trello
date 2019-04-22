package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.models.Desk;
import ru.itis.security.details.UserDetailsImpl;
import ru.itis.services.DeskService;
import ru.itis.services.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DesksController {

    @Autowired
    private DeskService deskService;

    @GetMapping(path = "/desks")
    public String getLoginPage(Authentication authentication, ModelMap model) {
        if (authentication == null) {
            return "redirect:login";
        }
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        Long userId = details.getUser().getId();

        List<Desk> desks = deskService.findAllUserDesks(userId);
        model.addAttribute("desks",desks);
        return "desks";
    }
}
