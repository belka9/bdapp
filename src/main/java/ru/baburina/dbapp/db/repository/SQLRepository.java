package ru.baburina.dbapp.db.repository;

import org.hibernate.transform.AliasToEntityMapResultTransformer;
import ru.baburina.dbapp.db.HibernateUtil;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class SQLRepository {

    public int getCount(String rawQuery) {
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            var query = session.createSQLQuery("SELECT COUNT(*) FROM (" + rawQuery + ") foo");
            return ((BigInteger)query.getSingleResult()).intValue();
        }
    }

    public List<Map<String, Object>> performQuery(String rawQuery, int pageSize, int page) {
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            var query = session.createSQLQuery(rawQuery);
            query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
            return query.setFirstResult(pageSize*(page-1)).setMaxResults(pageSize).list();
        }
    }

}
