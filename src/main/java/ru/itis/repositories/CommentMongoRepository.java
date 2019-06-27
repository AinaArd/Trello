package ru.itis.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.itis.models.CommentMongo;

import java.util.List;

public interface CommentMongoRepository extends MongoRepository<CommentMongo, Long> {
    List<CommentMongo> findAllByTaskId(Long taskId);
}
