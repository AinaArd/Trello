package ru.itis.utils;

public interface Cache {
    void add(Long key, Object value);

    void remove(Long key);

    Object get(Long key);

    void clear();

    long size();
}
