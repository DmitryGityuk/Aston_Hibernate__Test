package com.aston_hibernate.service.impl;

import com.aston_hibernate.dao.ProjectDao;
import com.aston_hibernate.entity.Project;
import com.aston_hibernate.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    @Transactional
    public void addProject(Project project) {
        projectDao.addProject(project);
    }

    @Override
    @Transactional
    public void updateProject(Project project) {
        projectDao.updateProject(project);
    }

    @Override
    @Transactional
    public void deleteProject(int id) {
        projectDao.deleteProject(id);
    }

    @Override
    @Transactional
    public Project getProjectById(int id) {
        return projectDao.getProjectById(id);
    }

    @Override
    @Transactional
    public List<Project> listProjects() {
        return projectDao.listProjects();
    }
}

