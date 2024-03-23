package tn.bal.pi.services;

import tn.bal.pi.entities.Projects;
import tn.bal.pi.entities.TypeNiveau;

import java.util.List;

public interface IProjectsService {
    List<Projects> getAllProjects();
    Projects getProjectById(Long id);
    Projects addProject(Projects p);
    Projects updateProject(Projects p);
    void deleteProjectById(Long id);
    List<Projects> getIsNominated(boolean b);
    List<Projects> currentlyNominated();
    List<Projects> getAllWinners(boolean b);
    List<Projects> getAllwinnersByYear(String scolarYear,boolean b);
    List<Projects> getGroupsByWinningSteak(Integer streakValue);
    List<Projects> getByCoach(String coach);
    List<Projects> getAllByCategory(String category);
    List<Projects> getAllByOptionSpeciality(String option);
    List<Projects> getAllByNiveau(TypeNiveau niveau);

}
