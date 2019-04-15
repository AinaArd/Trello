package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Comment;

public interface CommentsRepository extends JpaRepository<Comment, Long> {
}
