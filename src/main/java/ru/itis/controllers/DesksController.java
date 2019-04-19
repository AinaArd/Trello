package ru.itis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.models.Desk;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DesksController {
    @GetMapping(path = "/desks")
    public String getDesksPage(ModelMap model){
//        TODO: take desks of user from db
//        model.addAttribute("desks", desks);
        return "desks";
    }
}
