package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Elem;

public interface ElemRepository extends JpaRepository<Elem, Long> {
}
