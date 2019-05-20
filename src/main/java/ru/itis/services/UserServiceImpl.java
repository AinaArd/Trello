package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.forms.UserEditForm;
import ru.itis.forms.UserForm;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;
import ru.itis.security.details.UserDetailsImpl;
import ru.itis.transfer.UserDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ru.itis.transfer.UserDto.from;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public List<User> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long userId) {
        return usersRepository.findById(userId);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return usersRepository.findByLogin(login);
    }

    @Override
    public Optional<User> findByName(String name) {
        return usersRepository.findByName(name);
    }

    @Override
    public Optional<User> findByLoginAndPassword(UserForm userForm) {
        return usersRepository.findByLoginAndHashPassword(userForm.getLogin(), userForm.getPassword());
    }

    @Override
    public List<UserDto> findByNameOrLogin(String input, User user) {
        List<UserDto> users;
        UserDto currentUser = from(user);
        if (input.contains("@")) {
            users = usersRepository.findByLoginContaining(input);
            users.remove(currentUser);
        } else {
            users = usersRepository.findByNameContaining(input);
            users.remove(currentUser);
        }
        return users;
    }

    @Override
    public void saveAndFlush(UserEditForm userEditForm, Authentication authentication) {
        User user = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        user.setName(userEditForm.getName());
        user.setLogin(userEditForm.getNewLogin());
        user.setHashPassword(passwordEncoder.encode(userEditForm.getNewPassword()));
        usersRepository.saveAndFlush(user);
    }

    @Override
    public boolean checkLoginAndPassword(UserEditForm userEditForm) {
        if (userEditForm.getOldLogin().equals(userEditForm.getNewLogin())) {
            return false;
        }
        return !userEditForm.getOldPassword().equals(userEditForm.getNewPassword());
    }

    @Override
    public List<String> getNames(List<User> userCandidates) {
        return userCandidates.stream().map(user -> user.getName()).collect(Collectors.toList());
    }

    @Override
    public List<User> findAllMembers(Long deskId) {
        return usersRepository.findAllMembers(deskId);
    }
}
