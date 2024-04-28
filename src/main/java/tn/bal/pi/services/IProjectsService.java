package tn.bal.pi.services;

import tn.bal.pi.dto.ProjectsDto;
import tn.bal.pi.entities.Projects;
import tn.bal.pi.entities.TypeNiveau;

import java.util.List;

public interface IProjectsService extends AbstractService<ProjectsDto> {

    ProjectsDto customSave(Long optionId , Long categoryId , ProjectsDto dto);
    List<ProjectsDto> getIsNominated(boolean b);
    List<ProjectsDto> currentlyNominated();
    List<ProjectsDto> getAllWinners(boolean b);
    List<ProjectsDto> getAllwinnersByYear(String scolarYear,boolean b);
    List<ProjectsDto> getGroupsByWinningSteak(Integer streakValue);
    List<ProjectsDto> getByCoach(String coach);
    List<ProjectsDto> getAllByCategory(String category);
    List<ProjectsDto> getAllByOptionSpeciality(String option);
    List<ProjectsDto> getAllByNiveau(TypeNiveau niveau);

}
