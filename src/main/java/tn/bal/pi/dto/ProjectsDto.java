package tn.bal.pi.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tn.bal.pi.entities.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ProjectsDto {
    private Long id;
    private String nom;
    private String group;
    private boolean nominated;
    private Date date;
    private int numberOfVotes;
    private int groupStreak;
    private boolean winner;
    private TypeNiveau niveau;
    private Option optionSpeciality;
    private CategoryProjects category;
    private String coach;
    private boolean votingpool;
    private String scolarYear;
    private Long userId;

    public static ProjectsDto fromEntity(Projects projects){
        return ProjectsDto.builder()
                .id(projects.getId())
                .category(CategoryProjects
                        .builder()
                        .id(projects.getId())
                        .build())
                .nom(projects.getNom())
                .group(projects.getGroup())
                .nominated(projects.isNominated())
                .date(projects.getDate())
                .optionSpeciality(Option.builder()
                        .id(projects.getOptionSpeciality().getId())
                        .build())
                .numberOfVotes(projects.getNumberOfVotes())
                .userId(projects.getUser().getId())
                .groupStreak(projects.getGroupStreak())
                .winner(projects.isWinner())
                .niveau(projects.getNiveau())
                .votingpool(projects.isVotingpool())
                .scolarYear(projects.getScolarYear())
                .coach(projects.getCoach())
                .build();
    }
    public static Projects toEntity(ProjectsDto projects){
        return Projects.builder()
                .id(projects.getId())
                .user(User.builder()
                        .id(projects.getUserId()).build())
                .category(CategoryProjects
                        .builder()
                        .id(projects.getId())
                        .build())
                .nom(projects.getNom())
                .group(projects.getGroup())
                .nominated(projects.isNominated())
                .date(projects.getDate())
                .optionSpeciality(Option.builder()
                        .id(projects.getOptionSpeciality().getId())
                        .build())
                .numberOfVotes(projects.getNumberOfVotes())
                .groupStreak(projects.getGroupStreak())
                .winner(projects.isWinner())
                .niveau(projects.getNiveau())
                .votingpool(projects.isVotingpool())
                .scolarYear(projects.getScolarYear())
                .coach(projects.getCoach())
                .build();
    }
}
