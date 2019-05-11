package ru.itis.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.models.TaskState;
import ru.itis.models.User;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskForm {
    private String taskName;
    private String state;
}
