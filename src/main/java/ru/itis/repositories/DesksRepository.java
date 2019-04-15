package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Desk;

public interface DesksRepository extends JpaRepository<Desk, Long> {
}
