package ru.baburina.dbapp.app.services;

import ru.baburina.dbapp.db.api.Repository;

import java.util.Collection;
import java.util.stream.Collectors;

public abstract class AbstractEntityService<T, E> {

    protected final Repository<E, ?> repository;

    public AbstractEntityService(Repository<E, ?> repository) {
        this.repository = repository;
    }

    protected abstract T mapToModel(E entity);
    protected abstract E mapToEntity(T model);

    protected Collection<T> getEntities() {
        var entities = repository.getAll();
        return entities.stream().map(this::mapToModel).collect(Collectors.toList());
    }

    public Collection<T> getEntitesPage(int page, int pageSize) {
        var entites = repository.getPage(pageSize, page);
        return entites.stream().map(this::mapToModel).collect(Collectors.toList());
    }

    public int getCount() {
        return this.repository.count();
    }

    protected void createEntity(T model) {
        var entity = this.mapToEntity(model);
        repository.create(entity);
    }

    protected void updateEntity(T model) {
        var entity = this.mapToEntity(model);
        repository.update(entity);
    }

    protected void deleteEntity(T model) {
        var entity = this.mapToEntity(model);
        repository.delete(entity);
    }
}
