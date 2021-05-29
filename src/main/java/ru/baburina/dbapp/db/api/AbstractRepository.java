package ru.baburina.dbapp.db.api;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.baburina.dbapp.db.HibernateUtil;
import ru.baburina.dbapp.db.entities.UserEntity;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class AbstractRepository<T, K> implements Repository<T, K> {

    private final Class<T> type;

    public AbstractRepository(Class<T> type) {
        this.type = type;
    }

    @Override
    public Class<T> getType() {
        return this.type;
    }

    @Override
    public T findById(K id) {
        return this.run(s -> {
            return s.find(this.getType(), id);
        });
    }

    @Override
    public void create(T entity) {
        this.runInTransaction((s, t) -> {
            s.persist(entity);
            t.commit();
        });
    }

    @Override
    public void update(T entity) {
        this.runInTransaction((s, t) -> {
            s.update(entity);
            t.commit();
        });
    }

    @Override
    public void delete(T entity) {
        this.runInTransaction((s, t) -> {
            s.delete(entity);
            t.commit();
        });
    }

    protected <R> R run(Function<Session, R> action) {
        try(var session = HibernateUtil.getSessionFactory().openSession()) {
            return action.apply(session);
        }
    }

    protected <R> R runInTransaction(BiFunction<Session, Transaction, R> action) {
        return this.run(session -> {
            var transaction = session.beginTransaction();
            return action.apply(session, transaction);
        });
    }

    protected void run(Consumer<Session> action) {
        try(var session = HibernateUtil.getSessionFactory().openSession()) {
            action.accept(session);
        }
    }

    protected void runInTransaction(BiConsumer<Session, Transaction> action) {
        this.run(session -> {
            var transaction = session.beginTransaction();
            action.accept(session, transaction);
        });
    }



}
