package ru.itis.services;

import org.springframework.security.core.Authentication;
import ru.itis.forms.UserEditForm;
import ru.itis.forms.UserForm;
import ru.itis.models.Desk;
import ru.itis.models.User;
import ru.itis.transfer.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    Optional<User> findById(Long userId);

    Optional<User> findByLogin(String login);

    Optional<User> findByName(String name);

    Optional<User> findByLoginAndPassword(UserForm userForm);

    List<UserDto> findByNameOrLogin(String input, User user);

    void saveAndFlush(UserEditForm userEditForm, Authentication authentication);

    boolean checkLoginAndPassword(UserEditForm userEditForm);

    List<String> getNames(List<User> userCandidates);

    List<User> findAllMembers(Long deskId);

    Optional<User> addMembersToDesk(Long userId, Long deskId);

    User save(User user);

    void removeFromDesk(User user, Desk desk);
}
