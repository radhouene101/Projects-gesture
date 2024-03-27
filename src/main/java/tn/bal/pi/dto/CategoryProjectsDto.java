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
    public static CategoryProjectsDto fromEntity(CategoryProjects categoryProjects){
        return CategoryProjectsDto.builder()
                .id(categoryProjects.getId())
                .name(categoryProjects.getName())
                .description(categoryProjects.getDescription())
                .build();
    }
    public static CategoryProjects toEntity(CategoryProjectsDto categoryProjects){
        return CategoryProjects.builder()
                .id(categoryProjects.getId())
                .name(categoryProjects.getName())
                .description(categoryProjects.getDescription())
                .build();
    }
}
