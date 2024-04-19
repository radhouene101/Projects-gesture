package tn.bal.pi.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tn.bal.pi.entities.CategoryProjects;
import tn.bal.pi.entities.SousCategory;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class SousCategoryDto {

    private Long id;
    private String nom;
    private String description;

    public static SousCategoryDto fromEntity(SousCategory sousCategory){
        return SousCategoryDto.builder()
                .id(sousCategory.getId())
                .nom(sousCategory.getNom())
                .description(sousCategory.getDescription())
                .build();
    }
    public  static SousCategory toEntity(SousCategoryDto sousCategoryDto){
        return SousCategory.builder()
                .id(sousCategoryDto.getId())
                .nom(sousCategoryDto.getNom())
                .description(sousCategoryDto.getDescription())
                .build();
    }
}
