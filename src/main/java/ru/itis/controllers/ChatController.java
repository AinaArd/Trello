package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.models.Message;
import ru.itis.models.User;
import ru.itis.security.details.UserDetailsImpl;
import ru.itis.services.MessageService;
import ru.itis.services.UserService;
import ru.itis.transfer.MessageDto;

import static ru.itis.transfer.MessageDto.from;


@Controller
public class ChatController {

    private MessageService messageService;

    private UserService userService;

    private SimpMessageSendingOperations messagingTemplate;

    @Autowired
    public ChatController(SimpMessageSendingOperations messagingTemplate, MessageService messageService) {
        this.messagingTemplate = messagingTemplate;
        this.messageService = messageService;
    }


    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload Message message) {
        MessageDto messageDto = from(message);
        System.out.println(message);

//        messagingTemplate.convertAndSend("/topic/public", messageDto);

        messageService.addMessage(message);

        return message;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public Message addUser(@Payload Message message,
                           SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", message.getSender());
        return message;
    }

    @GetMapping("/chat")
    public String getChatPage(Authentication authentication, ModelMap model) {
        User currentUser = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        model.addAttribute("currentUser", currentUser);
        return "chat";
    }
}

