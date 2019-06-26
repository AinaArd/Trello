package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.forms.MessageForm;
import ru.itis.models.Desk;
import ru.itis.models.Message;
import ru.itis.models.User;
import ru.itis.security.details.UserDetailsImpl;
import ru.itis.services.DeskService;
import ru.itis.services.MessageService;

import java.util.List;


@Controller
public class ChatController {

    private MessageService messageService;
    private DeskService deskService;

    @Autowired
    public ChatController(MessageService messageService, DeskService deskService) {
        this.messageService = messageService;
        this.deskService = deskService;
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public MessageForm sendMessage(@Payload MessageForm messageForm) {
        messageService.addMessage(messageForm);
        return messageForm;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public Message addUser(@Payload Message message,
                           SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", message.getSender());
        return message;
    }

    @GetMapping("/chat/{desk-id}")
    public String getChatPage(Authentication authentication, ModelMap model, @PathVariable(name = "desk-id") Long deskId) {
        Desk desk = deskService.findOneDesk(deskId).orElseThrow(IllegalArgumentException::new);
        User currentUser = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        List<Message> messages = messageService.getDeskMessages(desk);

        model.addAttribute("messages", messages);
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("desk", desk);
        return "chat";
    }
}

