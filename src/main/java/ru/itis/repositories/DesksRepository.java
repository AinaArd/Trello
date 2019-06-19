package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.models.Desk;
import ru.itis.models.User;
import ru.itis.transfer.UserDto;

import javax.xml.ws.Action;
import java.util.List;
import java.util.Optional;

public interface DesksRepository extends JpaRepository<Desk, Long> {
    @Query(nativeQuery = true, value = "select * from desk inner join user_desks m2 on desk.id = m2.desks_id where m2.users_id = ?")
    List<Desk> findAllByDesk_members(Long id);

    @Override
    Optional<Desk> findById(Long id);

    List<Desk> findAll();

    @Override
    <S extends Desk> S save(S s);

//    @Query(nativeQuery = true, value = "with ins1 as (insert into desk (name, state) VALUES (?, ?)\n" +
//            "returning id)\n" +
//            "insert into desk_desk_members(desks_id, desk_members_id) values ((select id from ins1), ?)")
//    void addDesk(String name, String state, Long userId);

    @Query(nativeQuery = true, value = "select * from desk inner join card c2 on desk.id = c2.desk_id where c2.id = ?")
    Optional<Desk> findDeskByCard_id(Long cardId);

    @Query(nativeQuery = true, value = "select * from desk inner join \"user\" u on desk.owner = u.id where " +
            "u.name = ?")
    List<Desk> findAllByOwner_Name(String owner_name);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from desk where id = ?")
    void deleteDesk(Long deskId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from user_desks where desks_id = ?")
    void deleteDeskMembers(Long deskId);
}
