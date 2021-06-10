package ru.baburina.dbapp.db.repository;

import ru.baburina.dbapp.db.api.AbstractRepository;
import ru.baburina.dbapp.db.entities.StationEntity;
import ru.baburina.dbapp.db.entities.UserEntity;

import java.util.List;

public class StationRepository extends AbstractRepository<StationEntity, Integer>  {
    public StationRepository() {
        super(StationEntity.class);
    }

    @Override
    public int count() {
        return this.run(s -> {
            var query = s.createQuery("SELECT COUNT(*) FROM StationEntity u", Long.class);
            return query.getSingleResult().intValue();
        });
    }

    @Override
    public List<StationEntity> getAll() {
        return this.run(s -> {
            var query = s.createQuery("FROM StationEntity u", this.getType());
            return query.list();
        });
    }

    @Override
    public List<StationEntity> getPage(int pageSize, int page) {
        return this.run(s -> {
            var query = s.createQuery("FROM StationEntity u", this.getType());
            return query.setFirstResult(pageSize*(page-1)).setMaxResults(pageSize).list();
        });
    }
}
