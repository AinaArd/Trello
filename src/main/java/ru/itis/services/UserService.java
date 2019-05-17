package ru.itis.services;

import org.springframework.security.core.Authentication;
import ru.itis.forms.UserEditForm;
import ru.itis.forms.UserForm;
import ru.itis.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    Optional<User> findById(Long userId);

    Optional<User> findByLogin(String login);

    Optional<User> findByLoginAndPassword(UserForm userForm);

    List<User> findByNameOrLogin(String input);

    void saveAndFlush(UserEditForm userEditForm, Authentication authentication);

    boolean checkLoginAndPassword(UserEditForm userEditForm);

    List<String> getNames(List<User> userCandidates);
}
