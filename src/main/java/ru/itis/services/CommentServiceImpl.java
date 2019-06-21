package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.models.CommentMongo;
import ru.itis.models.Task;
import ru.itis.models.User;
import ru.itis.repositories.CommentMongoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentMongoRepository commentMongoRepository;
    private UserService userService;

    @Autowired
    public CommentServiceImpl(CommentMongoRepository commentMongoRepository, UserService userService) {
        this.commentMongoRepository = commentMongoRepository;
        this.userService = userService;
    }

    @Override
    public CommentMongo add(CommentMongo comment) {
        return commentMongoRepository.save(comment);
    }

    @Override
    public void setAuthor(User user, Task task) {
        List<CommentMongo> comments = commentMongoRepository.findAllByTaskId(task.getId());
        for(CommentMongo comment : comments){

        }
    }

    @Override
    public List<CommentMongo> findAllTaskComments(Task task) {
        return commentMongoRepository.findAllByTaskId(task.getId());
    }
}
