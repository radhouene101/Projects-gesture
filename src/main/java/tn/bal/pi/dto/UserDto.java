package tn.bal.pi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tn.bal.pi.entities.User;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDto {
    private String email;
    private String password;
    private String fullname;
    public static UserDto fromEntity(User user){
        return UserDto.builder()
                .fullname(user.getFullname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
    public static User toEntity(UserDto user){
        return User.builder()
                .fullname(user.getFullname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
