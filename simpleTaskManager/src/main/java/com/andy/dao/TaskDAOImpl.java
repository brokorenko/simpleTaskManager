package com.andy.dao;

import com.andy.model.Manager;
import com.andy.model.Project;
import com.andy.model.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew on 10.05.2017.
 */
public class TaskDAOImpl implements TaskDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Task> getAllProjectTasks(int projectId) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Project p where p.id=" + projectId);
        Project p = (Project) query.getSingleResult();
        return new ArrayList<Task>(p.getTasks());
    }

    public void createNewTask(Task task) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(task);
        transaction.commit();
        session.close();
    }
}
