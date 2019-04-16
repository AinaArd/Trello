package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.forms.UserForm;
import ru.itis.models.Role;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void register(UserForm userForm) {
        User user = User.builder()
                .login(userForm.getLogin())
                .hashPassword(userForm.getPassword())
                .name(userForm.getName())
                .role(Role.USER)
                .build();
        usersRepository.save(user);
    }

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


}
