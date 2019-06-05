package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.forms.RegisterForm;
import ru.itis.models.Role;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;

@Service
public class RegisterServiceImpl implements RegisterService {

    private UsersRepository usersRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterServiceImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(RegisterForm registerForm) {
        String hashPassword = passwordEncoder.encode(registerForm.getPassword());
        User user = User.builder()
                .login(registerForm.getLogin())
                .hashPassword(hashPassword)
                .name(registerForm.getName())
                .role(Role.USER)
                .build();
        usersRepository.save(user);
    }
}
