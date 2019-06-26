package ru.itis.services;

import ru.itis.models.Log;

import java.util.List;

public interface LogsService {
    void save(Log log);
    List<Log> findAll();
}
