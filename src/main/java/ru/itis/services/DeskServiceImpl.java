package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.models.Desk;
import ru.itis.repositories.DesksRepository;

import java.util.List;
import java.util.Optional;

@Component
public class DeskServiceImpl implements DeskService {

    @Autowired
    private DesksRepository desksRepository;

    @Override
    public List<Desk> findAllUserDesks(Long id) {
        return desksRepository.findAllByDesk_members(id);
    }

    @Override
    public Optional<Desk> findOneDesk(Long id) {
        return desksRepository.findById(id);
    }

    @Override
    public List<Desk> findAllUserDesksByName(String name) {
        return desksRepository.findAllByOwner_Name(name);
    }

    @Override
    public void deleteDesk(Desk desk) {
        desksRepository.deleteDesk(desk.getId());
        desksRepository.deleteDeskMembers(desk.getId());
    }

    @Override
    public void addDesk(Desk desk) {
        desksRepository.save(desk);
    }

//    @Override
//    public void addDeskOwner(Desk desk, User owner) {
//        owner.setRole(Role.CREATOR);
//        desksRepository.addDesk(desk.getName(), String.valueOf(desk.getState()), owner.getId());
//    }

    @Override
    public Optional<Desk> findDeskByCard(Long id) {
        return desksRepository.findDeskByCard_id(id);
    }

    @Override
    public List<Desk> findAllUserDesksByName(String name) {
        return desksRepository.findAllByOwner_Name(name);
    }

}