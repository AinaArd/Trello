package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.itis.forms.LoginForm;
import ru.itis.services.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;


@Controller
public class LoginController {

    @GetMapping(path = "/login")
    public String getLoginPage(Authentication authentication, ModelMap model, HttpServletRequest request, LoginForm loginForm) {
        if (authentication != null) {
            return "redirect:profile";
        }
        if (request.getParameterMap().containsKey("error")) {
            model.addAttribute("error", true);
        }
        return "login";
    }
}
