package tn.bal.pi.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.bal.pi.dto.ProjectsDto;
import tn.bal.pi.dto.SousCategoryDto;
import tn.bal.pi.entities.SousCategory;
import tn.bal.pi.repositories.SousCategoryRepository;
import tn.bal.pi.services.ISousCategoryService;
import tn.bal.pi.validator.ObjectsValidator;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SousCategoryServiceImpl implements ISousCategoryService {
    @Autowired
    private final SousCategoryRepository repository;
    @Autowired
    private  final ObjectsValidator validator;


    @Override
    public SousCategoryDto save(SousCategoryDto dto) {
        validator.validate(dto);
        SousCategory sousCategory = SousCategoryDto.toEntity(dto);
        repository.save(sousCategory);
        return SousCategoryDto.fromEntity(sousCategory);
    }

    @Override
    public List<SousCategoryDto> findAll() {
        return repository.findAll().stream()
                .map(SousCategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public SousCategoryDto findById(Long id) {
        return repository.findById(id).map(SousCategoryDto::fromEntity).orElseThrow(()-> new EntityNotFoundException("no project exist with id "+id));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }



}
