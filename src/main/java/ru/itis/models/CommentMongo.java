package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "comment")
public class CommentMongo {
    @Id
    private BigInteger id;

    @Field(value = "content")
    private String content;

    @Field(value = "author")
    private Long author;

    @Field(value = "task_id")
    private Long taskId;
}
