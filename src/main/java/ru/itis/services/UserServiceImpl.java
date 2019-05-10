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

import java.util.List;
import java.util.Optional;

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
    public Optional<User> findByLoginAndPassword(UserForm userForm) {
        return usersRepository.findByLoginAndHashPassword(userForm.getLogin(), userForm.getPassword());
    }

    @Override
    public List<User> findByNameOrLogin(String input) {
        if (input.contains("@")) {
            return usersRepository.findByLoginContaining(input);
        } else {
            return usersRepository.findByNameContaining(input);
        }
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
}
