package ru.aston.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static void createSessionFactory() {
       sessionFactory = new Configuration()
               .configure()
               .buildSessionFactory();
    }
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            createSessionFactory();
        }
        return sessionFactory;
    }
}
