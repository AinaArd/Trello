package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.models.Desk;

import java.util.List;

public interface DesksRepository extends JpaRepository<Desk, Long> {
    @Query(nativeQuery = true, value = "select * from desk inner join desk_desk_members m2 on desk.id = m2.desks_id where m2.desk_members_id = ?")
    List<Desk> findAllByDesk_members(Long id);

    List<Desk> findAll();
}
