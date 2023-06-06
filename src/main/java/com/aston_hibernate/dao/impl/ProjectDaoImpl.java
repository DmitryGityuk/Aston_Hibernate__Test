package com.aston_hibernate.dao.impl;

import com.aston_hibernate.dao.ProjectDao;
import com.aston_hibernate.entity.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDaoImpl implements ProjectDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addProject(Project project) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(project);
    }

    @Override
    public void updateProject(Project project) {
        Session session = sessionFactory.getCurrentSession();
        session.update(project);
    }

    @Override
    public void deleteProject(int id) {
        Session session = sessionFactory.getCurrentSession();
        Project project = session.load(Project.class, new Integer(id));
        if (project != null) {
            session.delete(project);
        }
    }

    @Override
    public Project getProjectById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Project project = session.load(Project.class, new Integer(id));
        return project;
    }

    @Override
    public List<Project> listProjects() {
        Session session = sessionFactory.getCurrentSession();
        List<Project> projects = session.createQuery("from Project").list();
        return projects;
    }
}
