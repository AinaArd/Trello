package ru.itis.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.models.Card;
import ru.itis.models.Desk;
import ru.itis.models.DeskState;
import ru.itis.models.User;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeskDto {
    private Long id;
    private String name;
    private DeskState state;
    private List<User> deskMembers;
    private List<Card> cards;

    public static DeskDto from(Desk desk) {
        return DeskDto.builder()
                .name(desk.getName())
                .state(desk.getState())
                .deskMembers(desk.getUsers())
                .cards(desk.getCards())
                .build();
    }
}
