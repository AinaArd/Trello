package ru.itis.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.validation.Login;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginForm {
    @Login
    private String login;
    private String password;
}
