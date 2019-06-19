package ru.itis.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.validation.Login;
import ru.itis.validation.Password;

import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterForm {

    @Login
    @Size(min = 3, max = 30)
    private String login;

    @Password
    @Size(min = 3, max = 30)
    private String password;

    @Size(min = 3, max = 30)
    private String name;
}
