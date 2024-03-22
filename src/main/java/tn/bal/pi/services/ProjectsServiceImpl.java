package tn.bal.pi.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.bal.pi.entities.Projects;
import tn.bal.pi.repositories.ProjectsRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectsServiceImpl implements IProjectsService{
    ProjectsRepository projectsRepository;
    @Override
    public List<Projects> getAllProjects() {
        return projectsRepository.findAll();
    }

    @Override
    public Projects getProjectById(Long id) {
        return projectsRepository.findById(id).get();
    }

    @Override
    public Projects addProject(Projects p) {
        return projectsRepository.save(p);
    }

    @Override
    public Projects updateProject(Projects p) {
        return projectsRepository.save(p);
    }

    @Override
    public void deleteProjectById(Long id) {
        System.out.println("project with id   "+ id + " name "+  getProjectById(id).getNom() + " is deleted");
        projectsRepository.deleteById(id);
        System.out.println("project with id " +id + "deleted");
    }
}
