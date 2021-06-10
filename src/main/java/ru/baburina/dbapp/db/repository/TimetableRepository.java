package ru.baburina.dbapp.db.repository;

import ru.baburina.dbapp.db.api.AbstractRepository;
import ru.baburina.dbapp.db.entities.MarshrutEntity;
import ru.baburina.dbapp.db.entities.TimetableEntity;
import ru.baburina.dbapp.db.entities.TimetablePKEntity;

import java.util.List;

public class TimetableRepository extends AbstractRepository<TimetableEntity, TimetablePKEntity> {
    public TimetableRepository() {
        super(TimetableEntity.class);
    }

    @Override
    public int count() {
        return this.run(s -> {
            var query = s.createQuery("SELECT COUNT(*) FROM TimetableEntity u", Long.class);
            return query.getSingleResult().intValue();
        });
    }

    @Override
    public List getAll() {
        return this.run(s -> {
            var query = s.createQuery("FROM TimetableEntity u", this.getType());
            return query.list();
        });
    }

    @Override
    public List getPage(int pageSize, int page) {
        return this.run(s -> {
            var query = s.createQuery("FROM TimetableEntity u", this.getType());
            return query.setFirstResult(pageSize*(page-1)).setMaxResults(pageSize).list();
        });
    }
}
