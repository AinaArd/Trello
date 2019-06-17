package ru.itis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.telegram.telegrambots.ApiContextInitializer;
//import org.telegram.telegrambots.meta.TelegramBotsApi;
//import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
//import ru.itis.models.TelegramBot;
import ru.itis.services.DeskService;
import ru.itis.services.UserService;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "ru.itis.repositories")
@EntityScan(basePackages = "ru.itis.models")
public class Application {

    public static void main(String[] args) {
//        ApiContextInitializer.init();
//        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
//        try {
//            telegramBotsApi.registerBot(new TelegramBot());
//        } catch (TelegramApiRequestException e) {
//            e.printStackTrace();
//        }
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
