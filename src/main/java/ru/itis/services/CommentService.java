package ru.itis.services;

import ru.itis.models.CommentMongo;
import ru.itis.models.Task;
import ru.itis.models.User;

import java.util.List;

public interface CommentService {

    CommentMongo add(CommentMongo comment);

    void setAuthor(User user, Task task);

    List<CommentMongo> findAllTaskComments(Task task);

}
