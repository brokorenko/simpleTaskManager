package com.andy.dao;

import com.andy.model.Manager;
import com.andy.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Andrew on 28.03.2017.
 */
public class ProjectDAOImpl implements ProjectDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Project> getAllManagerProjects(int managerId) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Manager m where m.id=" + managerId);
        Manager m = (Manager) query.getSingleResult();
        return new ArrayList<Project>(m.getProjects());
    }

    public void createNewProject(Project project) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(project);
        transaction.commit();
        session.close();
    }
}
