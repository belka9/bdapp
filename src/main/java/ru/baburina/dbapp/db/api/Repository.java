package ru.baburina.dbapp.db.api;

import java.util.List;

public interface Repository<T, K> {

    Class<T> getType();

    T findById(K id);

    int count();

    List<T> getAll();

    List<T> getPage(int pageSize, int page);

    void create(T entity);

    void update(T entity);

    void delete(T entity);

}
