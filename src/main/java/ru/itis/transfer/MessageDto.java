package ru.itis.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.models.Message;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {
    private Long id;
    private String sender;
    private String content;

    public static MessageDto from(Message message) {
        return MessageDto.builder()
                .id(message.getId())
                .sender(message.getSender())
                .content(message.getContent())
                .build();
    }
}
