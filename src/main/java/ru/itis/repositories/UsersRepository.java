package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
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

    @Query(nativeQuery = true, value = "select * from \"user\" inner join user_desks ud on \"user\".id = ud.users_id where desks_id = ?")
    List<User> findAllMembers(Long deskId);

    @Query(nativeQuery = true, value = "insert into user_desks(users_id, desks_id) values(?,?)")
    void addMembersToDesk(Long userId, Long deskId);

    @Query(nativeQuery = true, value = "insert into user_tasks(users_id, tasks_id) values(?,?)")
    void addMembersToTask(Long userId, Long taskId);

    @Query(nativeQuery = true, value = "select users_id from user_desks" +
            " where exists (select * from user_desks where users_id = ? and desks_id = ?)")
    List<Long> findAllByDeskIdOrUserId(Long userId, Long deskId);

    @Query(nativeQuery = true, value = "select * from user_desks ud inner join \"user\" u on ud.users_id = u.id where users_id = ?")
    Optional<User> findMemberById(Long userId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from user_desks where users_id = ?1 and desks_id = ?2")
    void removeFromDesk(Long userId, Long deskId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from user_tasks where users_id = ?1 and tasks_id = ?2")
    void removeFromTask(Long userId, Long taskId);

    @Query(nativeQuery = true, value = "select count(1) from \"user\" inner join comment c on \"user\".id = c.author where \"user\".id = ?")
    int countComments(Long userId);
}
