package com.andy.dao;

import com.andy.model.Developer;
import com.andy.model.Manager;
import com.andy.model.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 * Created by Andrew on 13.05.2017.
 */
public class DeveloperDAOImpl implements DeveloperDAO{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Developer getDeveloperByName(Developer developer) {
        Session session = sessionFactory.openSession();
        String s = developer.getDeveloper_full_Name();
        Query query = session.createQuery("from Developer d where d.developer_full_Name =: s");
        query.setParameter("s", s);
        Developer developerResult = (Developer) query.getSingleResult();
        session.close();
        return developerResult;
    }

    public void setTaskForDeveloper(Task task) {

    }
}
