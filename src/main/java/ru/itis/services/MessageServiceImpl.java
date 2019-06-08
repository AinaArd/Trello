package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.models.Message;
import ru.itis.models.User;
import ru.itis.repositories.MessageRepository;

import java.util.List;

public class MessageServiceImpl implements MessageService {

    private MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> getUserChats(User user) {
        return messageRepository.getAllByUser(user.getId());
    }

    @Override
    public Message addMessage(Message message) {
        return messageRepository.save(message);
    }
}
