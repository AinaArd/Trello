package ru.itis.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.itis.models.User;

@Data
@Builder
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String login;
    private String name;
    private String password;

    public static UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .login(user.getLogin())
                .password(user.getHashPassword())
                .build();
    }
}