package ru.itis.utils;

import java.util.HashMap;
import java.util.List;

public class CacheCards implements Cache{

    private HashMap<Long, List<Object>> cache = new HashMap<>();

    @Override
    public void add(Long key, Object value) {

    }

    @Override
    public void remove(Long key) {

    }

    @Override
    public Object get(Long key) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public long size() {
        return 0;
    }
}
