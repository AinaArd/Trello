package ru.itis.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import ru.itis.validation.Login;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginForm {
    private String login;
    private String password;
    private Double x;
    private Double y;
}
