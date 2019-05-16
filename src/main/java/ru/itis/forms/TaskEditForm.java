package ru.itis.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskEditForm {
    private String name;
    private String text;
    private String state;
    private MultipartFile file;
}
