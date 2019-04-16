package ru.itis.services;

import ru.itis.forms.UserForm;
import ru.itis.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void register(UserForm userForm);
    List<User> findAll();
    Optional<User> findById(Long userId);
}