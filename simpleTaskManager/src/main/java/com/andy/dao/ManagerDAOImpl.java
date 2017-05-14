package com.andy.dao;

import com.andy.model.Manager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ManagerDAOImpl implements ManagerDAO {
    private SessionFactory sessionFactory;


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Manager manager) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(manager);
        transaction.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<Manager> list() {
        Session session = sessionFactory.openSession();
        List<Manager> list = session.createQuery("from Manager").list();
        session.close();
        return list;
    }

    public Manager getManagerById(int id) {
        Session session = sessionFactory.openSession();
        Manager manager = (Manager) session.createQuery("from Manager m where m.manager_id =" + id).getSingleResult();
        session.close();
        return manager;
    }

    public Manager getManagerByManagerName(int id) {
        Session session = sessionFactory.openSession();
        Manager manager = (Manager) session.createQuery("from Manager m where m.manager_id =" + id).getSingleResult();
        session.close();
        return manager;
    }

    public int getIdByManagerLogin(String login) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Manager m where m.manager_login=:login");
        query.setParameter("login", login);
        Manager manager = (Manager) query.getSingleResult();
        session.close();
        return manager.getManager_id();
    }


    public Manager getManagerByLoginForm(String managerLogin, String managerPassword) {
        List<Manager> list = list();
        for (Manager m:list
             ) {
            if (m.getManager_login().equals(managerLogin) && m.getManager_password().equals(managerPassword)){
                return m;
            }
        }
        return null;
    }
}
