package ru.itis.services;

import org.springframework.stereotype.Service;
import ru.itis.forms.MessageForm;
import ru.itis.models.Desk;
import ru.itis.models.Message;
import ru.itis.models.User;

import java.util.List;

public interface MessageService {
    List<Message> getUserChats(User user);
    Message addMessage(MessageForm messageForm);

    List<Message> getDeskMessages(Desk desk);
}
