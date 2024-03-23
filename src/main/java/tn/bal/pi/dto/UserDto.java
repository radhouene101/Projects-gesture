package tn.bal.pi.dto;

import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;
import tn.bal.pi.entities.User;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDto {

    private Long id;
    @Email
    @NotBlank(message = "email should not be blank")
    @NotNull(message = "email should not be Null")
    @NotEmpty(message = "email should Not be Empty!")
    private String email;
    @NotBlank(message = "password should not be blank")
    @NotNull(message = "password should not be Null")
    @NotEmpty(message = "password should Not be Empty!")
    @Size(min = 2 , max = 32)
    private String password;
    @NotBlank(message = "fullname should not be blank")
    @NotNull(message = "fullname should not be Null")
    @NotEmpty(message = "fullname should Not be Empty!")
    private String fullname;
    public static UserDto fromEntity(User user){
        return UserDto.builder()
                .id(user.getId())
                .fullname(user.getFullname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
    public static User toEntity(UserDto user){
        return User.builder()
                .id(user.getId())
                .fullname(user.getFullname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
