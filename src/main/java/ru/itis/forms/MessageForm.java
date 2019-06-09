package ru.itis.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class MessageForm {
    private String sender;
    private String content;
    private Integer desk;
    private String type;
}
