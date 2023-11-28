package ru.aston.dao;


import org.hibernate.Session;
import ru.aston.entity.Company;
import ru.aston.util.HibernateUtil;

import java.util.List;

public class CompanyDAO implements EntityDAO<Company> {

    @Override
    public Company showById(int id) {
        try (Session currentSession = HibernateUtil.getSessionFactory().openSession()){
            return currentSession.get(Company.class, id);
        }
    }

    @Override
    public List<Company> showAll() {
        try (Session currentSession = HibernateUtil.getSessionFactory().openSession()){
            return currentSession.createQuery("SELECT * FROM Company", Company.class).getResultList();
        }
    }

    @Override
    public void save(Company entity) {
        try (Session currentSession = HibernateUtil.getSessionFactory().openSession()){
            currentSession.beginTransaction();
            currentSession.save(entity);
            currentSession.beginTransaction().commit();
        }
    }

    @Override
    public void update(Company entity) {
        try (Session currentSession = HibernateUtil.getSessionFactory().openSession()) {
            currentSession.beginTransaction();
            currentSession.update(entity);
            currentSession.getTransaction().commit();
        }
    }

    @Override
    public void delete(Company entity) {
        try (Session currentSession = HibernateUtil.getSessionFactory().openSession()) {
            currentSession.beginTransaction();
            currentSession.delete(entity);
            currentSession.getTransaction().commit();
        }
    }
}
