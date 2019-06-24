package ru.itis.services;

import ru.itis.models.CommentMongo;
import ru.itis.models.Task;
import ru.itis.models.User;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface CommentService {

    CommentMongo add(CommentMongo comment);

//    Map<BigInteger, User> setAuthors(Task task);

    List<CommentMongo> findAllTaskComments(Task task);

}
