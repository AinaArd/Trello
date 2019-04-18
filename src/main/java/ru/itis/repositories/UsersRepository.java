package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    List<User> findAll();
    Optional<User> findById(Long id);
    Optional<User> findByLogin(String login);
    Optional<User> findByLoginAndHashPassword(String login, String password);
    <S extends User> S saveAndFlush(S s);
    <S extends User> S save(S s);

    @Query(nativeQuery = true, value = "UPDATE \"user\" SET name=?, login=?, hash_password=? where id = ?")
    void update(String name, String login, String hashPassword, Long id);


}
