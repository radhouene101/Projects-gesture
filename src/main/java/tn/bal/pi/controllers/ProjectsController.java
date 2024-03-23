package tn.bal.pi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.bal.pi.dto.ProjectsDto;

import tn.bal.pi.services.IProjectsService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("projects")
@AllArgsConstructor
public class ProjectsController {
    @Autowired
    IProjectsService service;
    @GetMapping
    public ResponseEntity<List<ProjectsDto>> getAllProjects() {
        return ResponseEntity
                .ok(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProjectsDto> getProjectById(@PathVariable Long id){
        return ResponseEntity
                .ok( service.findById(id));
    }
    @PostMapping
    public ResponseEntity<ProjectsDto> addProject(@RequestBody ProjectsDto p){
        return ResponseEntity
                .ok(service.save(p));
    }
   /* @PostMapping("/update")
    public ProjectsDto updateProject(@RequestBody ProjectsDto p){
        return service.updateProject(p);
    }*/
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id){

        service.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/nominated")
    public ResponseEntity<List<ProjectsDto>> getNominatedProjects(){
        return ResponseEntity.ok(
                service.getIsNominated(true));
    }

    @GetMapping("/scolar-year/{scolarYear}")
    public ResponseEntity<List<ProjectsDto>> getAllWinnersByYear(@PathVariable String scolarYear){
        return ResponseEntity
                .ok(service.getAllwinnersByYear(scolarYear,true));
    }
    @GetMapping("/scolar-year")
    public ResponseEntity<List<ProjectsDto>> getAllWinners(boolean b){
        return ResponseEntity
                .ok(service.getAllWinners(true));
    }
    @GetMapping("/hall-of-fame-groups")
    public ResponseEntity<List<String>> getGroupsByWinningSteak(Integer steakValue){
        List<ProjectsDto>  p;
        p= service.getGroupsByWinningSteak(0);
        List<String> listOfGroupNames= new ArrayList<>();
        for (ProjectsDto pr:p){
            listOfGroupNames.add(pr.getGroup());
        }
        return  ResponseEntity.ok(listOfGroupNames);
    }
}
