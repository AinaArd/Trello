package ru.itis.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.itis.models.CommentMongo;

import java.math.BigInteger;
import java.util.List;

public interface CommentMongoRepository extends MongoRepository<CommentMongo, BigInteger> {
    List<CommentMongo> findAllByTaskId(Long id);
}
