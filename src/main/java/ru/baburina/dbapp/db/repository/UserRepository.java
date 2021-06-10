package ru.baburina.dbapp.db.repository;

import ru.baburina.dbapp.db.api.AbstractRepository;
import ru.baburina.dbapp.db.entities.UserEntity;

import java.util.List;

public class UserRepository extends AbstractRepository<UserEntity, Integer> {

    public UserRepository() {
        super(UserEntity.class);
    }

    public UserEntity find(String name, String password) {
        return this.run(s -> {
            var q = s.createQuery("FROM UserEntity u WHERE u.name = :name AND u.password = :password", this.getType());
            q.setParameter("name", name);
            q.setParameter("password", password);
            return q.getSingleResult();
        });
    }

    @Override
    public int count() {
        return this.run(s -> {
            var query = s.createQuery("SELECT COUNT(*) FROM UserEntity u", Long.class);
            return query.getSingleResult().intValue();
        });
    }

    @Override
    public List<UserEntity> getAll() {
        return this.run(s -> {
            var query = s.createQuery("FROM UserEntity u", this.getType());
            return query.list();
        });
    }

    @Override
    public List<UserEntity> getPage(int pageSize, int page) {
        return this.run(s -> {
            var query = s.createQuery("FROM UserEntity u", this.getType());
            return query.setFirstResult(pageSize*(page-1)).setMaxResults(pageSize).list();
        });
    }
}
