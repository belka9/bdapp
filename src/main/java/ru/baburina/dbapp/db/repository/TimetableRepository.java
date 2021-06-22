package ru.baburina.dbapp.db.repository;

import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Restrictions;
import ru.baburina.dbapp.app.models.TimetableModel;
import ru.baburina.dbapp.db.api.AbstractRepository;
import ru.baburina.dbapp.db.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<TimetableEntity> getAll() {
        return this.run(s -> {
            var query = s.createQuery("FROM TimetableEntity u", this.getType());
            return query.list();
        });
    }

    @Override
    public List<TimetableEntity> getPage(int pageSize, int page) {
        return this.run(s -> {
            var query = s.createQuery("FROM TimetableEntity u", this.getType());
            return query.setFirstResult(pageSize*(page-1)).setMaxResults(pageSize).list();
        });
    }

   public List<ScheduledTrainEntity> findTrainsByDauStations(int st1, int st2, Instant dt1, Instant dt2){
        return this.run(s -> {
            var em = s.getEntityManagerFactory().createEntityManager();
            var cb = em.getCriteriaBuilder();
            var query = cb.createQuery();
            var tt1 = query.from(TimetableEntity.class);
            var tt2 = query.from(TimetableEntity.class);
            query.select(cb.tuple(tt1.get(TimetableEntity_.pkEntity).get(TimetablePKEntity_.id), tt1.get(TimetableEntity_.train)));
            query.where(
                    cb.and(
                            cb.equal(tt1.get(TimetableEntity_.pkEntity).get(TimetablePKEntity_.id),
                                    tt2.get(TimetableEntity_.pkEntity).get(TimetablePKEntity_.id)),
                            cb.equal(tt1.get(TimetableEntity_.station).get(StationEntity_.id), st1),
                            cb.equal(tt2.get(TimetableEntity_.station).get(StationEntity_.id), st2),
                            cb.greaterThan(tt2.get(TimetableEntity_.dt1), tt1.get(TimetableEntity_.dt1)),
                            cb.between(tt1.get(TimetableEntity_.dt2), dt1, dt2)
                    )
            );
            query.distinct(true);
            return em.createQuery(query).getResultList().stream().map(t -> {
                var tuple = (Object[])t;
                var res = new ScheduledTrainEntity();
                res.setTimetableId((int)tuple[0]);
                res.setTrain((TrainEntity)tuple[1]);
                return res;
            }).collect(Collectors.toList());
        });
    }

    public List<TimetableEntity> getEntitiesBetween(int id, int st1, int st2) {
        return this.run(s ->{
            var em = s.getEntityManagerFactory().createEntityManager();
            var cb = em.getCriteriaBuilder();
            var query = cb.createQuery(TimetableEntity.class);
            var tt = query.from(TimetableEntity.class);
            var tt1 = query.from(TimetableEntity.class);
            var tt2 = query.from(TimetableEntity.class);
            query.select(tt);
            query.where(cb.and(
                    cb.equal(tt.get(TimetableEntity_.pkEntity).get(TimetablePKEntity_.id), id),
                    cb.equal(tt1.get(TimetableEntity_.pkEntity).get(TimetablePKEntity_.id), id),
                    cb.equal(tt1.get(TimetableEntity_.pkEntity).get(TimetablePKEntity_.stationId), st1),
                    cb.equal(tt2.get(TimetableEntity_.pkEntity).get(TimetablePKEntity_.id), id),
                    cb.equal(tt2.get(TimetableEntity_.pkEntity).get(TimetablePKEntity_.stationId), st2),
                    cb.greaterThanOrEqualTo(tt.get(TimetableEntity_.dt2), tt1.get(TimetableEntity_.dt2)),
                    cb.lessThanOrEqualTo(tt.get(TimetableEntity_.dt1), tt2.get(TimetableEntity_.dt1))
            ));
            query.orderBy(cb.asc(tt.get(TimetableEntity_.dt1)));
            return em.createQuery(query).getResultList();
        });

    }
    public TimetableEntity getIdForBuy(int id, int id_station){
        return this.run(s->{
            var em = s.getEntityManagerFactory().createEntityManager();
            var cb = em.getCriteriaBuilder();
            var query = cb.createQuery(TimetableEntity.class);
            var tt = query.from(TimetableEntity.class);
            query.select(tt);
            query.where(cb.and(
                    cb.equal(tt.get(TimetableEntity_.pkEntity).get(TimetablePKEntity_.id), id),
                    cb.equal(tt.get(TimetableEntity_.pkEntity).get(TimetablePKEntity_.stationId), id_station)));
            return em.createQuery(query).getSingleResult();
        });
    }
}
