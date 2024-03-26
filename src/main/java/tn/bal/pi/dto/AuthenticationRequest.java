package tn.bal.pi.dto;


import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class AuthenticationRequest {
    private String email;
    private String password;

}
