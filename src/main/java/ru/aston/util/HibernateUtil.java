package ru.aston.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.aston.entity.Company;
import ru.aston.entity.Department;
import ru.aston.entity.Employee;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static void createSessionFactory() {
       sessionFactory = new Configuration()
               .configure()
               .addAnnotatedClass(Company.class)
               .addAnnotatedClass(Department.class)
               .addAnnotatedClass(Employee.class)
               .buildSessionFactory();
    }
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            createSessionFactory();
        }
        return sessionFactory;
    }
}
