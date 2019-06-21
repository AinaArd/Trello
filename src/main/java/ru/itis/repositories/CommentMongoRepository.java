package ru.itis.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.itis.models.CommentMongo;

public interface CommentMongoRepository extends MongoRepository<CommentMongo, Long> {
}
