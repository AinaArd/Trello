package ru.itis.services;

import ru.itis.models.CommentMongo;

public interface CommentService {
    CommentMongo add(CommentMongo comment);
}
