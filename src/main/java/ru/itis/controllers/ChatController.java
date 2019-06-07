package ru.itis.controllers;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.models.Message;
import ru.itis.models.User;
import ru.itis.security.details.UserDetailsImpl;

@Controller
public class ChatController {

	@MessageMapping("/message")
	@SendTo("/chat/messages")
	public Message getMessages(Message message) {
		return message;
	}

	@GetMapping("/chat")
	public String getChatPage(ModelMap model, Authentication authentication){
		User currentUser = ((UserDetailsImpl)authentication.getPrincipal()).getUser();
		model.addAttribute("user", currentUser);
		return "chat";
	}
}

