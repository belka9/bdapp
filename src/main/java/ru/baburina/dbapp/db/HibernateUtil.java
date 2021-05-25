package ru.baburina.dbapp.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            var configFileURI = HibernateUtil.class.getClassLoader().getResource("hibernate.cfg.xml");
            return  new Configuration()
                    .configure(new File(configFileURI.getFile()))
                    .addPackage("ru.baburina.dbapp.entities")
                    .buildSessionFactory();
        } catch (Throwable ex)
        {
            System.err.println("Session factory create fail" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }


}
