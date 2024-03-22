package tn.bal.pi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.bal.pi.entities.Projects;
import tn.bal.pi.services.IProjectsService;

import java.util.List;

@RestController
@RequestMapping("projects")
@AllArgsConstructor
public class ProjectsController {
    @Autowired
    IProjectsService iProjectsService;
    @GetMapping
    public List<Projects> getAllProjects(){
        return iProjectsService.getAllProjects();
    }
    @GetMapping("/{id}")
    public Projects getProjectById(@PathVariable Long id){
        return iProjectsService.getProjectById(id);
    }
    @PostMapping
    public Projects addProject(@RequestBody Projects p){
        return iProjectsService.addProject(p);
    }
    @PostMapping("/update")
    public Projects updateProject(@RequestBody Projects p){
        return iProjectsService.updateProject(p);
    }
    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id){
        iProjectsService.deleteProjectById(id);
    }
    @GetMapping("/nominated")
    public List<Projects> getNominatedProjects(){
        return iProjectsService.getIsNominated();
    }
}
