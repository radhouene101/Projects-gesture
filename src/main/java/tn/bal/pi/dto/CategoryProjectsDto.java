package tn.bal.pi.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tn.bal.pi.entities.CategoryProjects;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class CategoryProjectsDto {
    private Long id;
    private String nom;
    private String description;
    public static CategoryProjectsDto fromEntity(CategoryProjects categoryProjects){
        return CategoryProjectsDto.builder()
                .id(categoryProjects.getId())
                .nom(categoryProjects.getNom())
                .description(categoryProjects.getDescription())
                .build();
    }
    public static CategoryProjects toEntity(CategoryProjectsDto categoryProjects){
        return CategoryProjects.builder()
                .id(categoryProjects.getId())
                .nom(categoryProjects.getNom())
                .description(categoryProjects.getDescription())
                .build();
    }
}
