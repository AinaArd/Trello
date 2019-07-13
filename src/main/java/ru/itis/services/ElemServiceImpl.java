package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.models.Elem;
import ru.itis.repositories.ElemRepository;

@Service
public class ElemServiceImpl implements ElemService {

    @Autowired
    private ElemRepository elemRepository;

    @Override
    public Elem addElem(Elem elem) {
        return elemRepository.save(elem);
    }
}
