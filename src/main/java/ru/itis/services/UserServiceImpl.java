package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.forms.EditForm;
import ru.itis.forms.UserForm;
import ru.itis.models.Role;
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
    public void saveAndFlush(EditForm editForm, Authentication authentication) {
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        details.getUser().setName(editForm.getName());
        details.getUser().setLogin(editForm.getNewLogin());
        details.getUser().setHashPassword(passwordEncoder.encode(editForm.getNewPassword()));
        usersRepository.saveAndFlush(details.getUser());
    }

    @Override
    public boolean checkLoginAndPassword(EditForm editForm) {
        if(editForm.getOldLogin().equals(editForm.getNewLogin())){
            return false;
        }
        return !editForm.getOldPassword().equals(editForm.getNewPassword());
    }
}
