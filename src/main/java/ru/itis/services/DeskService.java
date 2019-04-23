package ru.itis.services;

import org.springframework.stereotype.Service;
import ru.itis.models.Desk;

import java.util.List;
import java.util.Optional;

@Service
public interface DeskService {
    List<Desk> findAllUserDesks(Long id);
    Optional<Desk> findOneDesk(Long id);
}