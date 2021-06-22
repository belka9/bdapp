package ru.baburina.dbapp.db.repository;

import ru.baburina.dbapp.db.api.AbstractRepository;
import ru.baburina.dbapp.db.entities.TicketsEntity;

import java.util.List;

public class TicketsRepository extends AbstractRepository<TicketsEntity, Integer> {

    public TicketsRepository() {
        super(TicketsEntity.class);
    }

    @Override
    public int count() {
        return this.run(s -> {
            var q = s.createQuery("SELECT COUNT(*) FROM TicketsEntity t", Long.class);
            return q.getSingleResult().intValue();
        });
    }

    @Override
    public List<TicketsEntity> getAll() {
        return this.run(s -> {
            var q = s.createQuery("FROM TicketsEntity t", TicketsEntity.class);
            return q.getResultList();
        });
    }

    @Override
    public List<TicketsEntity> getPage(int pageSize, int page) {
        return this.run(s -> {
            var q = s.createQuery("FROM TicketsEntity t", TicketsEntity.class);
            q.setFirstResult((page - 1)*pageSize).setMaxResults(pageSize);
            return q.getResultList();
        });
    }
}
