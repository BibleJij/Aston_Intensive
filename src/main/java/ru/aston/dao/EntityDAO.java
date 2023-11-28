package ru.aston.dao;

import java.util.List;

public interface EntityDAO<E> {
    E showById(int id);
    List<E> showAll();
    void save(E entity);
    void update(E entity);
    void delete(E entity);

}
