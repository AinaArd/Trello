//package ru.itis.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//import ru.itis.models.Desk;
//import ru.itis.repositories.DesksRepository;
//
//import java.util.List;
//
//@Component
//public class DeskServiceImpl implements DeskService {
//
//    @Autowired
//    private DesksRepository desksRepository;
//
//    @Override
//    public List<Desk> findAllUserDesks(Long id) {
//        return desksRepository.findAllByDesk_members(id);
//    }
//}