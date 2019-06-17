//package ru.itis.models;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.telegram.telegrambots.bots.TelegramLongPollingBot;
//import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
//import org.telegram.telegrambots.meta.api.objects.Update;
//import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
//import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
//import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
//import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
//import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
//import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
//import ru.itis.services.DeskService;
//import ru.itis.services.UserService;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class TelegramBot extends TelegramLongPollingBot {
//
//    @Autowired
//    private DeskService deskService;
//
//    @Autowired
//    private UserService userService;
//
////    @Autowired
////    public TelegramBot(DeskService deskService, UserService userService) {
////        this.deskService = deskService;
////        this.userService = userService;
////    }
//
//
//    private void start(SendMessage message) {
//        message.setText("Our commands: \n/mydesks - returns your desks;\n/mytasks - returns your tasks");
//        setButtons(message);
//    }
//
//    @Override
//    public void onUpdateReceived(Update update) {
//        SendMessage message = new SendMessage();
//        if (update.hasMessage()) {
//            message.setChatId(update.getMessage().getChatId());
//
//            String command = update.getMessage().getText();
//            String userName = update.getMessage().getFrom().getFirstName();
//
//            switch (command) {
//                case "/start":
//                    start(message);
//                    break;
//                case "/mydesks":
//                    findDesks(message, userName);
//                    break;
//                case "/mytasks":
//                    findTasks(message, userName);
//                    break;
//            }
//            try {
//                execute(message);
//            } catch (TelegramApiException e) {
//                e.printStackTrace();
//            }
//        }
//
//        if (update.hasCallbackQuery()) {
//            try {
//                execute(message.setText(
//                        update.getCallbackQuery().getData())
//                        .setChatId(update.getCallbackQuery().getMessage().getChatId()));
//            } catch (TelegramApiException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private void findTasks(SendMessage message, String userName) {
////        User user = userService.findByName(userName).orElseThrow(IllegalArgumentException::new);
////        System.out.println(user.getName());
////        List<String> tasks = user.getTasks().stream().map(task -> task.getText()).collect(Collectors.toList());
////        message.setText(String.valueOf(tasks));
//    }
//
//    private void findDesks(SendMessage message, String userName) {
//        if (deskService.findAllUserDesksByName(userName) != null) {
//            List<String> desks = deskService.findAllUserDesksByName(userName).stream().map(desk -> desk.getName())
//                    .collect(Collectors.toList());
//            System.out.println(desks.get(0));
//            message.setText(String.valueOf(desks));
//        } else {
//            System.out.println("This user has no desks");
//        }
//    }
//
//    private synchronized void setButtons(SendMessage sendMessage) {
//        // Create keyboard:
//        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
//        sendMessage.setReplyMarkup(replyKeyboardMarkup);
//        replyKeyboardMarkup.setSelective(true).setResizeKeyboard(true).setOneTimeKeyboard(false);
//
//        // 1st row:
//        KeyboardRow keyboardFirstRow = new KeyboardRow() {{
//            add(new KeyboardButton("/mydesks"));
//        }};
//
//        // 2nd row:
//        KeyboardRow keyboardSecondRow = new KeyboardRow() {{
//            add(new KeyboardButton("/mytasks"));
//        }};
//
//        // Keyboard rows:
//        List<KeyboardRow> keyboard = new ArrayList<>();
//        keyboard.add(keyboardFirstRow);
//        keyboard.add(keyboardSecondRow);
//
//        replyKeyboardMarkup.setKeyboard(keyboard);
//    }
//
//    @Override
//    public String getBotUsername() {
//        return "AinaTrello";
//    }
//
//    @Override
//    public String getBotToken() {
//        return "769300787:AAHnOGUq9zjib3wdjFBpyYdEe2g2JdwZnas";
//    }
//}