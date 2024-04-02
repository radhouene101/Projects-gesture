package tn.bal.pi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.bal.pi.configuration.JwtUtils;
import tn.bal.pi.dto.AuthenticationRequest;
import tn.bal.pi.dto.AuthenticationResponse;
import tn.bal.pi.dto.UserDto;
import tn.bal.pi.repositories.UserRepository;
import tn.bal.pi.services.IUserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private final IUserService service;
    @Autowired
    private final AuthenticationManager authenticationManager;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final JwtUtils jwtUtils;
    @PostMapping("/register")

    public ResponseEntity<AuthenticationResponse> register(@RequestBody UserDto userDto){
        return ResponseEntity.ok(service.register(userDto));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest req){
        return ResponseEntity.ok(service.authenticate(req));
    }
}
