package ru.itis.services;

import org.springframework.stereotype.Service;
import ru.itis.models.CheckList;
import ru.itis.repositories.CheckListRepository;
import ru.itis.transfer.CheckListDto;

import java.util.Optional;

import static ru.itis.transfer.CheckListDto.from;

@Service
public class CheckListServiceImpl implements CheckListService {

    private final CheckListRepository checkListRepository;

    public CheckListServiceImpl(CheckListRepository checkListRepository) {
        this.checkListRepository = checkListRepository;
    }

    @Override
    public CheckListDto addCheckList(CheckList checkList) {
        CheckList newCheckList = checkListRepository.save(checkList);
        CheckListDto dto = from(newCheckList);
        return dto;
    }

    @Override
    public Optional<CheckList> findCheckListById(Long listId) {
        return checkListRepository.findById(listId);
    }

    @Override
    public void delete(CheckList checkList) {
        checkListRepository.delete(checkList);
    }
}
