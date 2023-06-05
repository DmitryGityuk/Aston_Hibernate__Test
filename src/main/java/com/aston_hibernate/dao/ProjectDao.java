package com.aston_hibernate.dao;

import com.aston_hibernate.entity.Project;

import java.util.List;

public interface ProjectDao {

    void addProject(Project project);

    void updateProject(Project project);

    void deleteProject(int id);

    Project getProjectById(int id);

    List<Project> listProjects();
}
