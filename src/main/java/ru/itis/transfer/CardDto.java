package ru.itis.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.models.Card;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardDto {
    private Long id;
    private String name;
    private Long deskId;

    public static CardDto from(Card card){
        return CardDto.builder()
                .id(card.getId())
                .name(card.getName())
                .deskId(card.getDesk().getId())
                .build();
    }
}
