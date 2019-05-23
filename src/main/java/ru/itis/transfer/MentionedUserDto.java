package ru.itis.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.models.Comment;
import ru.itis.models.User;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MentionedUserDto {
    private Long id;
    private String mentioned;
    private String author;
    private String commentText;

    public static MentionedUserDto from(User user, Comment comment, String content) {
        return MentionedUserDto.builder()
                .id(user.getId())
                .mentioned(user.getName())
                .author(comment.getAuthor().getName())
                .commentText(content)
                .build();
    }
}
