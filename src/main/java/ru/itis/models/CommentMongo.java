package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "comment")
public class CommentMongo {

    @Field(value = "content")
    private String content;

    @Field(value = "author")
    private Long author;

    @Field(value = "task_id")
    private Long taskId;
}
