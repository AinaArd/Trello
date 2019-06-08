package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.models.Message;
import ru.itis.models.User;
import ru.itis.repositories.MessageRepository;

import java.util.List;

@Service
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
        System.out.println(message.getContent());
        return messageRepository.save(message);
    }
}
