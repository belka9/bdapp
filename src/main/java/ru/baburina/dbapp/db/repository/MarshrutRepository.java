package ru.baburina.dbapp.db.repository;

import ru.baburina.dbapp.db.api.AbstractRepository;
import ru.baburina.dbapp.db.entities.MarshrutEntity;
import ru.baburina.dbapp.db.entities.MarshrutPKEntity;

import java.util.List;

public class MarshrutRepository extends AbstractRepository<MarshrutEntity, MarshrutPKEntity> {
    public MarshrutRepository() {
        super(MarshrutEntity.class);
    }

    @Override
    public int count() {
        return this.run(s -> {
            var query = s.createQuery("SELECT COUNT(*) FROM MarshrutEntity u", Long.class);
            return query.getSingleResult().intValue();
        });
    }

    @Override
    public List getAll() {
        return this.run(s -> {
            var query = s.createQuery("FROM MarshrutEntity u", this.getType());
            return query.list();
        });
    }

    @Override
    public List getPage(int pageSize, int page) {
        return this.run(s -> {
            var query = s.createQuery("FROM MarshrutEntity u", this.getType());
            return query.setFirstResult(pageSize*(page-1)).setMaxResults(pageSize).list();
        });
    }
}

