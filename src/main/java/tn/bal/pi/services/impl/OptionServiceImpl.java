package tn.bal.pi.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.bal.pi.dto.OptionDto;
import tn.bal.pi.entities.Option;
import tn.bal.pi.repositories.OptionRepository;
import tn.bal.pi.services.IOptionService;
import tn.bal.pi.validator.ObjectsValidator;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OptionServiceImpl implements IOptionService {
    @Autowired
    private final OptionRepository repository;
    @Autowired
    private final ObjectsValidator<OptionDto> validator;

    @Override
    public OptionDto save(OptionDto dto) {
        validator.validate(dto);
        Option option = OptionDto.toEntity(dto);
        repository.save(option);
        return OptionDto.fromEntity(option);
    }

    @Override
    public List<OptionDto> findAll() {
        return repository.findAll().stream()
                .map(OptionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public OptionDto findById(Long id) {
        return repository.findById(id)
                .map(OptionDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("no option exist with id :"+id));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }
}
