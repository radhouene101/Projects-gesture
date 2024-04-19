package tn.bal.pi.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tn.bal.pi.entities.CategoryProjects;
import tn.bal.pi.entities.SousCategory;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@Setter
@AllArgsConstructor

public class CategoryProjectsDto {
    private Long id;
    @NotBlank(message = "nom should not be blank")
    @NotNull(message = "nom should not be Null")
    @NotEmpty(message = "nom should Not be Empty!")
    private String name;
    @NotBlank(message = "description should not be blank")
    @NotNull(message = "description should not be Null")
    @NotEmpty(message = "description should Not be Empty!")
    private String description;

    private List<SousCategory> sousCategory;
    public static CategoryProjectsDto fromEntity(CategoryProjects categoryProjects){

        return CategoryProjectsDto.builder()
                .id(categoryProjects.getId())
                .name(categoryProjects.getName())
                .description(categoryProjects.getDescription())
                .sousCategory(categoryProjects.getSousCategories())
                .build();
    }
    public static CategoryProjects toEntity(CategoryProjectsDto categoryProjects){
        return CategoryProjects.builder()
                .id(categoryProjects.getId())
                .name(categoryProjects.getName())
                .description(categoryProjects.getDescription())
                .sousCategories(categoryProjects.getSousCategory())
                .build();
    }
}
