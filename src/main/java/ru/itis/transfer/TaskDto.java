package ru.itis.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.models.Task;
import ru.itis.models.TaskState;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private Long id;
    private String name;
    private String text;
    private String picturePath;
    private boolean flag;
    private String state;

    public static TaskDto from(Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .name(task.getName())
                .text(task.getText())
//                .picturePath(task.getPicturePath())
//                .flag(task.getFlag())
//                .state(task.getState())
                .build();
    }
}
