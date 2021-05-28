package ru.baburina.dbapp.db;

import ru.baburina.dbapp.db.entities.AaUsersEntity;

public class UserRepository {

    public AaUsersEntity getUser(String login, String password) {
        try(var session = HibernateUtil.getSessionFactory().openSession()) {
            var userQuery = session.createQuery("FROM AaUsersEntity u WHERE u.name = :name AND u.password = :password", AaUsersEntity.class);
            userQuery.setParameter("name", login);
            userQuery.setParameter("password", password);
            var result = userQuery.getSingleResult();
            return result;
        } catch (Throwable e) {
            System.out.println("error :(");
        }
        return null;
    }

}
