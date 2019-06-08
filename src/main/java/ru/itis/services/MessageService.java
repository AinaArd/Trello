package ru.itis.services;

import org.springframework.stereotype.Service;
import ru.itis.models.Message;
import ru.itis.models.User;

import java.util.List;

@Service
public interface MessageService {
    List<Message> getUserChats(User user);
    Message addMessage(Message message);
}
