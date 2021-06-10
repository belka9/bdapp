package ru.baburina.dbapp.db.repository;

import ru.baburina.dbapp.db.api.AbstractRepository;
import ru.baburina.dbapp.db.entities.StationEntity;
import ru.baburina.dbapp.db.entities.TrainEntity;

import java.util.List;

public class TrainRepository extends AbstractRepository<TrainEntity, Integer> {
    public TrainRepository() {
        super(TrainEntity.class);
    }

    @Override
    public int count() {
        return this.run(s -> {
            var query = s.createQuery("SELECT COUNT(*) FROM TrainEntity u", Long.class);
            return query.getSingleResult().intValue();
        });
    }

    @Override
    public List getAll() {
        return this.run(s -> {
            var query = s.createQuery("FROM TrainEntity u", this.getType());
            return query.list();
        });
    }

    @Override
    public List getPage(int pageSize, int page) {
        return this.run(s -> {
            var query = s.createQuery("FROM TrainEntity u", this.getType());
            return query.setFirstResult(pageSize*(page-1)).setMaxResults(pageSize).list();
        });
    }
}
