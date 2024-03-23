package tn.bal.pi.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.bal.pi.entities.Projects;
import tn.bal.pi.entities.TypeNiveau;
import tn.bal.pi.repositories.ProjectsRepository;

import java.util.List;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class ProjectsServiceImpl implements IProjectsService{
    @Autowired
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

    @Override
    public List<Projects> getIsNominated(boolean b) {
        return projectsRepository.findAllByNominated(b);
    }

    @Override
    public List<Projects> currentlyNominated() {
        return null;
    }

    public List<Projects> getAllWinners(boolean b){
        return projectsRepository.findAllByWinner(b);
    }
    @Override
    public List<Projects> getAllwinnersByYear(String scolarYear,boolean b) {
        return projectsRepository.findAllByWinnerAndAndScolarYear(b,scolarYear);
    }

    @Override
    public List<Projects> getGroupsByWinningSteak(Integer streakValue) {
        return projectsRepository.findGroupByGroupStreakGreaterThanOrderByGroupStreak(streakValue);
    }

    @Override
    public List<Projects> getByCoach(String coach) {
        return null;
    }

    @Override
    public List<Projects> getAllByCategory(String category) {
        return null;
    }

    @Override
    public List<Projects> getAllByOptionSpeciality(String option) {
        return null;
    }

    @Override
    public List<Projects> getAllByNiveau(TypeNiveau niveau) {
        return null;
    }
}
