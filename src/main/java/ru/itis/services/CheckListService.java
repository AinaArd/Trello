package ru.itis.services;

import ru.itis.models.CheckList;
import ru.itis.transfer.CheckListDto;

import java.util.Optional;

public interface CheckListService {
    CheckListDto addCheckList(CheckList checkList);

    Optional<CheckList> findCheckListById(Long listId);

    void delete(CheckList checkList);
}
