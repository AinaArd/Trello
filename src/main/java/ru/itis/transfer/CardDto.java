package ru.itis.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.itis.models.Card;
import ru.itis.models.CardState;

@Data
@Builder
@AllArgsConstructor
public class CardDto {
    private String name;
    private Data date;
    private CardState state;

    public static CardDto from(Card card) {
        return CardDto.builder()
                .name(card.getName())
                .build();
    }
}
