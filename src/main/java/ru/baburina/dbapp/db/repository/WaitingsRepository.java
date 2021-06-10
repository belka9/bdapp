package ru.baburina.dbapp.db.repository;

import ru.baburina.dbapp.db.api.AbstractRepository;
import ru.baburina.dbapp.db.entities.WaitingsEntity;

import java.util.List;

public class WaitingsRepository extends AbstractRepository<WaitingsEntity, Integer> {
    public WaitingsRepository() {
        super(WaitingsEntity.class);
    }

    @Override
    public int count() {
        return this.run(s -> {
            var query = s.createQuery("SELECT COUNT(*) FROM WaitingsEntity u", Long.class);
            return query.getSingleResult().intValue();
        });
    }

    @Override
    public List<WaitingsEntity> getAll() {
        return this.run(s -> {
            var query = s.createQuery("FROM WaitingsEntity u", this.getType());
            return query.list();
        });
    }

    @Override
    public List<WaitingsEntity> getPage(int pageSize, int page) {
        return this.run(s -> {
            var query = s.createQuery("FROM WaitingsEntity u", this.getType());
            return query.setFirstResult(pageSize*(page-1)).setMaxResults(pageSize).list();
        });
    }
}
