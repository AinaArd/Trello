package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.forms.UserEditForm;
import ru.itis.forms.RegisterForm;
import ru.itis.models.Desk;
import ru.itis.models.Role;
import ru.itis.models.Task;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;
import ru.itis.security.details.UserDetailsImpl;
import ru.itis.transfer.UserDto;
import ru.itis.utils.FileDownloader;

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

    @Autowired
    private FileDownloader fileDownloader;

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
    public Optional<User> findByLoginAndPassword(RegisterForm registerForm) {
        return usersRepository.findByLoginAndHashPassword(registerForm.getLogin(), registerForm.getPassword());
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

    public List<UserDto> findByNameOrLogin(String input) {
        List<UserDto> users;
        if (input.contains("@")) {
            users = usersRepository.findByLoginContaining(input);
        } else {
            users = usersRepository.findByNameContaining(input);
        }
        return users;
    }

    @Override
    public void edit(UserEditForm userEditForm, Authentication authentication) {
        System.out.println(userEditForm.getFile().getName());
        User user = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        String photoPath = fileDownloader.uploadProfilePic(userEditForm.getFile(), userEditForm.getName()).orElseThrow(IllegalArgumentException::new);
        user.setName(userEditForm.getName());
        user.setLogin(userEditForm.getNewLogin());
        user.setHashPassword(passwordEncoder.encode(userEditForm.getNewPassword()));
        System.out.println(photoPath);
        user.setPhotoPath(photoPath);
        usersRepository.saveAndFlush(user);
    }

    @Override
    public boolean checkLoginAndPassword(UserEditForm userEditForm) {
        if (userEditForm.getNewLogin().equals(userEditForm.getOldLogin()) || userEditForm.getNewPassword().equals(userEditForm
                .getOldPassword())) {
            return false;
        }
        return true;
    }

    @Override
    public List<String> getNames(List<User> userCandidates) {
        return userCandidates.stream().map(user -> user.getName()).collect(Collectors.toList());
    }

    @Override
    public List<User> findAllMembers(Long deskId) {
        return usersRepository.findAllMembers(deskId);
    }

    @Override
    public Optional<User> addMembersToDesk(Long userId, Long deskId) {
        if (usersRepository.findAllByDeskIdOrUserId(userId, deskId).isEmpty()) {
            usersRepository.addMembersToDesk(userId, deskId);
            return usersRepository.findMemberById(userId);
        } else {
            System.out.println("duplicate");
        }
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        return usersRepository.save(user);
    }

    @Override
    public void removeFromDesk(User user, Desk desk) {
        usersRepository.removeFromDesk(user.getId(), desk.getId());
    }

    @Override
    public boolean checkForUniqueness(String login) {
        return !usersRepository.findByLogin(login).isPresent();
    }

    @Override
    public void removeFromTask(User user, Task task) {
        usersRepository.removeFromTask(user.getId(), task.getId());
    }

    @Override
    public User getCurrentUser(Authentication authentication) {
        return ((UserDetailsImpl) authentication.getPrincipal()).getUser();
    }

    @Override
    public boolean register(RegisterForm registerForm) {
        String hashPassword = passwordEncoder.encode(registerForm.getPassword());
        User user = User.builder()
                .login(registerForm.getLogin())
                .hashPassword(hashPassword)
                .name(registerForm.getName())
                .role(Role.USER)
                .build();
        usersRepository.save(user);
        return true;
    }

    @Override
    public int countCommentsAmount(UserDto user) {
        return usersRepository.countComments(user.getId());
    }

}
