package ru.itis.forms;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EditForm {
    private String name;
    private String login;
    private String password;
}
