package tn.bal.pi.dto;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.*;
import tn.bal.pi.entities.Contest;
import tn.bal.pi.entities.Option;
import tn.bal.pi.entities.Projects;
import tn.bal.pi.entities.TypeNiveau;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ContestDto {

    private Long id;
    private String name;
    private String description;
    private TypeNiveau niveau;
    @JsonIdentityReference(alwaysAsId = true)
    private List<ProjectsDto> projects;
    private Option option;

    public static ContestDto fromEntity(Contest contest){
        return ContestDto.builder()
                .id(contest.getId())
                .name(contest.getName())
                .description(contest.getDescription())
                .projects(contest.getProjects()
                        .stream()
                        .map(ProjectsDto::fromEntity)
                        .collect(Collectors.toList()))
                .option(contest.getOption())
                .niveau(contest.getNiveau())
                .build();
    }
    public static Contest toEntity(ContestDto contest){
        return Contest.builder()
                .id(contest.getId())
                .name(contest.getName())
                .description(contest.getDescription())
                .projects(contest.getProjects()
                        .stream()
                        .map(ProjectsDto::toEntity)
                        .collect(Collectors.toList()))
                .option(
                        Option.builder()
                                .id(contest.getOption().getId())
                                .build())
                .niveau(contest.getNiveau())
                .build();
    }



}
