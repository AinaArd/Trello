package ru.itis.services;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.forms.TaskEditForm;
import ru.itis.models.Card;
import ru.itis.models.Comment;
import ru.itis.models.Task;
import ru.itis.transfer.TaskDto;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> findCardTasks(Card card);

    Optional<Task> findTaskById(Long id);

    TaskDto addTask(Task task);

    List<List<Task>> findAllTasksInAllCards(List<Card> cards);

    void edit(TaskEditForm taskEditForm, Task task);

    void addText(TaskEditForm taskEditForm, Task task);

    void archive(Task task);

    Comment addComment(Comment comment);

    void changeFlag(Task task);

    void deleteTask(Task task);
}
