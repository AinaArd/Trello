package ru.itis.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.itis.services.DeskService;

import java.util.List;

public class TelegramBot extends TelegramLongPollingBot {

    @Autowired
    private DeskService deskService;

    @Override
    public void onUpdateReceived(Update update) {
        String command = update.getMessage().getText();
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        if (command.equals("/mydesks")) {
//            TODO: take all user desks
            String userName = update.getMessage().getFrom().getFirstName();
            System.out.println(userName);
            List<String> desks = deskService.findAllUserDesksByName(userName);
            System.out.println(desks);
            sendMessage.setText(String.valueOf(desks));
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "AinaTrello";
    }

    @Override
    public String getBotToken() {
        return "769300787:AAHnOGUq9zjib3wdjFBpyYdEe2g2JdwZnas";
    }
}