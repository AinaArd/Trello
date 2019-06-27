package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.models.Log;
import ru.itis.repositories.LogsRepository;

import java.util.List;

@Service
public class LogsServiceImpl implements LogsService {

    @Autowired
    private LogsRepository logsRepository;

    @Override
    public void save(Log log) {
        logsRepository.save(log);
    }

    @Override
    public List<Log> findAll() {
        return logsRepository.findAll();
    }
}
