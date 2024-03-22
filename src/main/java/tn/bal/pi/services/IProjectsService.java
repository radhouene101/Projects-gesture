package tn.bal.pi.services;

import tn.bal.pi.entities.Projects;

import java.util.List;

public interface IProjectsService {
    List<Projects> getAllProjects();
    Projects getProjectById(Long id);
    Projects addProject(Projects p);
    Projects updateProject(Projects p);
    void deleteProjectById(Long id);
}
