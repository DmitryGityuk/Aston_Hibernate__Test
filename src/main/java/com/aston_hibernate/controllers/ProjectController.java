package com.aston_hibernate.controllers;

import com.aston_hibernate.entity.Project;
import com.aston_hibernate.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")
    public List<Project> showAllEmployees() {
        List<Project> allProjects = projectService.listProjects();
        return allProjects;
    }

    @GetMapping("/projects/{id}")
    public Project getProject(@PathVariable int id) {
        Project project = projectService.getProjectById(id);
        return project;
    }

    @PostMapping("/projects")
    public Project addNewProject(@RequestBody Project project) {
        projectService.addProject(project);
        return project;
    }

    @PutMapping("/projects")
    public Project updateProject(@RequestBody Project project) {
        projectService.updateProject(project);
        return project;
    }

    @DeleteMapping("/projects/{id}")
    public String deleteProject(@PathVariable int id) {
        projectService.deleteProject(id);
        return "Project with ID = " + id + " was successfuly deleted";
    }
}
