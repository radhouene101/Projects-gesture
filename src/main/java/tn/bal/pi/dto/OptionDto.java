package tn.bal.pi.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tn.bal.pi.entities.Option;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class OptionDto {
    private Long id;
    private String name;
    private String description;
    public static OptionDto fromEntity(Option option){
        return OptionDto.builder()
                .id(option.getId())
                .description(option.getDescription())
                .name(option.getName())
                .build();
    }
    public static Option toEntity(OptionDto option){
        return Option.builder()
                .id(option.getId())
                .description(option.getDescription())
                .name(option.getName())
                .build();
    }
}
