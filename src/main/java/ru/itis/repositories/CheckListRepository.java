package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.CheckList;

public interface CheckListRepository extends JpaRepository<CheckList, Long> {
}
