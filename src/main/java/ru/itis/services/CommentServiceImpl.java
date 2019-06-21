package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.models.CommentMongo;
import ru.itis.repositories.CommentMongoRepository;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMongoRepository commentMongoRepository;

    @Override
    public CommentMongo add(CommentMongo comment) {
        return commentMongoRepository.save(comment);
    }
}
