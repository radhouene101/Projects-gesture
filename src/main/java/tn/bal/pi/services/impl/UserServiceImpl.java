package tn.bal.pi.services.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.bal.pi.configuration.JwtUtils;
import tn.bal.pi.dto.AuthenticationRequest;
import tn.bal.pi.dto.AuthenticationResponse;
import tn.bal.pi.dto.UserDto;
import tn.bal.pi.entities.Role;
import tn.bal.pi.entities.User;
import tn.bal.pi.repositories.RoleRepository;
import tn.bal.pi.repositories.UserRepository;
import tn.bal.pi.services.IUserService;
import tn.bal.pi.validator.ObjectsValidator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements IUserService {
    private static final String ROLE_USER = "ROLE_USER";
    @Autowired
    private final UserRepository repository;
    @Autowired
    private final ObjectsValidator<UserDto> validator;

    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDto save(UserDto dto) {
        validator.validate(dto);
        User user = UserDto.toEntity(dto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
        return UserDto.fromEntity(user);
    }

    @Override
    public List<UserDto> findAll() {
        return repository.findAll().stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id) {
        return repository.findById(id)
                .map(UserDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("no user exist with id : "+id));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Long validateAccount(Long id) {
        User user = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("no user exist with id : "+id));
        user.setValidate(true);
        repository.save(user);
        return user.getId();
    }

    @Override
    public Long invalidateAccount(Long id) {
        User user = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("no user exist with id : "+id));
        user.setValidate(false);
        repository.save(user);
        return user.getId();

    }

    @Override
    @Transactional
    public AuthenticationResponse register(UserDto dto) {
        validator.validate(dto);
        User user = UserDto.toEntity(dto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(
                findOrCreateRole(ROLE_USER)
        );
        var savedUser = repository.save(user);
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", savedUser.getId());
        claims.put("fullName", savedUser.getFullname());
        String token = jwtUtils.generateToken(savedUser, claims);
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        final User user = repository.findByEmail(request.getEmail()).get();
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("fullName", user.getFullname());
        final String token = jwtUtils.generateToken(user, claims);
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }
    private Role findOrCreateRole(String roleName) {
        Role role = roleRepository.findByName(roleName)
                .orElse(null);
        if (role == null) {
            return roleRepository.save(
                    Role.builder()
                            .name(roleName)
                            .build()
            );
        }
        return role;
    }
}
