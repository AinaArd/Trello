package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.User;
import ru.itis.transfer.UserDto;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    List<User> findAll();
    Optional<User> findById(Long id);
    Optional<User> findByLogin(String login);
    Optional<User> findByName(String name);
    Optional<User> findByLoginAndHashPassword(String login, String password);
    <S extends User> S saveAndFlush(S s);
    <S extends User> S save(S s);
    List<UserDto> findByNameContaining(String name);
    List<UserDto> findByLoginContaining(String name);

}
