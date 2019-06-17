package ru.itis.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import ru.itis.validation.Login;
import ru.itis.validation.Password;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEditForm {
    private String name;
    private String oldLogin;

//    @Login
    private String newLogin;
    private String oldPassword;

    @Password
    private String newPassword;
}
