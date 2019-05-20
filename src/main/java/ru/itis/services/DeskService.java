package ru.itis.services;

import org.springframework.stereotype.Service;
import ru.itis.models.Desk;
import ru.itis.models.User;
import ru.itis.transfer.UserDto;

import java.util.List;
import java.util.Optional;

@Service
public interface DeskService {
    List<Desk> findAllUserDesks(Long id);
    Optional<Desk> findOneDesk(Long id);
    void addDesk(Desk desk);
    Optional<Desk> findDeskByCard(Long id);
    void addMembersToDesk(Long userId, Long deskId);
}