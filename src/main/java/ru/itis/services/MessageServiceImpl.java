package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.forms.MessageForm;
import ru.itis.models.Desk;
import ru.itis.models.Message;
import ru.itis.models.User;
import ru.itis.repositories.MessageRepository;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageRepository messageRepository;
    private DeskService deskService;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository, DeskService deskService) {
        this.messageRepository = messageRepository;
        this.deskService = deskService;
    }

    @Override
    public List<Message> getUserChats(User user) {
        return messageRepository.getAllByUser(user.getId());
    }

    @Override
    public Message addMessage(MessageForm messageForm) {
        Desk desk = deskService.findOneDesk(Long.valueOf(messageForm.getDesk())).orElseThrow(IllegalArgumentException::new);
        Message message = Message.builder()
                .content(messageForm.getContent())
                .sender(messageForm.getSender())
                .desk(desk)
                .build();
        return messageRepository.save(message);
    }

    @Override
    public List<Message> getDeskMessages(Desk desk) {
        return messageRepository.findAllByDesk(desk);
    }
}
