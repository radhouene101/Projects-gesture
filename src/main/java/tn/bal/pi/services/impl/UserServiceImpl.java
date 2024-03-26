package tn.bal.pi.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.bal.pi.dto.UserDto;
import tn.bal.pi.entities.User;
import tn.bal.pi.exceptions.ObjectValidationException;
import tn.bal.pi.repositories.UserRepository;
import tn.bal.pi.services.IUserService;
import tn.bal.pi.validator.ObjectsValidator;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private final UserRepository repository;
    @Autowired
    private final ObjectsValidator<UserDto> validator;

    @Override
    public UserDto save(UserDto dto) {
        validator.validate(dto);
        User user = UserDto.toEntity(dto);
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
}
