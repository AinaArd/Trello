package ru.itis.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.validation.Login;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterForm {

    @Login
    @Size(min = 5, max = 30)
    private String login;

    @Size(min = 5, max = 30)
    private String password;

    @Size(min = 3, max = 20)
    private String name;

//    TODO: add profile picture
//    private String picturePath;
}
