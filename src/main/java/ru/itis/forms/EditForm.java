package ru.itis.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class  EditForm {
    private String name;
    private String oldLogin;
    private String newLogin;
    private String oldPassword;
    private String newPassword;
}
