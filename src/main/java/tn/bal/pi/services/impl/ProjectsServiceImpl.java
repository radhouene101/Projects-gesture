package tn.bal.pi.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.bal.pi.dto.ProjectsDto;
import tn.bal.pi.entities.Projects;
import tn.bal.pi.entities.TypeNiveau;
import tn.bal.pi.repositories.ProjectsRepository;
import tn.bal.pi.services.IProjectsService;
import tn.bal.pi.validator.ObjectsValidator;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectsServiceImpl implements IProjectsService {
    @Autowired
    private  final ProjectsRepository repository;
    @Autowired
    private  final ObjectsValidator validator;


    @Override
    public ProjectsDto save(ProjectsDto dto) {
        validator.validate(dto);
        Projects project = ProjectsDto.toEntity(dto);
        repository.save(project);
        return ProjectsDto.fromEntity(project);
    }

    @Override
    public List<ProjectsDto> findAll() {
        return repository.findAll().stream()
                .map(ProjectsDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectsDto findById(Long id) {
        return repository.findById(id).map(ProjectsDto::fromEntity).orElseThrow(()-> new EntityNotFoundException("no project exist with id "+id));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }


    @Override
    public List<ProjectsDto> getIsNominated(boolean b) {
        return repository.findAllByNominated(b)
                .stream()
                .map(ProjectsDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProjectsDto> currentlyNominated() {
        return null;
    }
    public List<ProjectsDto> getAllWinners(boolean b){
        return repository.findAllByWinner(b)
                .stream()
                .map(ProjectsDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProjectsDto> getAllwinnersByYear(String scolarYear,boolean b) {
        return repository.findAllByWinnerAndAndScolarYear(b,scolarYear)
                .stream()
                .map(ProjectsDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProjectsDto> getGroupsByWinningSteak(Integer streakValue) {
        return repository.findGroupByGroupStreakGreaterThanOrderByGroupStreak(streakValue)
                .stream()
                .map(ProjectsDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProjectsDto> getByCoach(String coach) {
        return null;
    }

    @Override
    public List<ProjectsDto> getAllByCategory(String category) {
        return null;
    }

    @Override
    public List<ProjectsDto> getAllByOptionSpeciality(String option) {
        return null;
    }

    @Override
    public List<ProjectsDto> getAllByNiveau(TypeNiveau niveau) {
        return null;
    }
}
