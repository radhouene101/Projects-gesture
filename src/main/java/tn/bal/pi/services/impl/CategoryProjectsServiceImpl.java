package tn.bal.pi.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.bal.pi.dto.CategoryProjectsDto;
import tn.bal.pi.entities.CategoryProjects;
import tn.bal.pi.repositories.CategoryProjectsRepository;
import tn.bal.pi.services.ICategoryProjectsService;
import tn.bal.pi.validator.ObjectsValidator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryProjectsServiceImpl implements ICategoryProjectsService {
    @Autowired
    private  final CategoryProjectsRepository repository;

    private final ObjectsValidator<CategoryProjectsDto> validator;

    // in each of these methods we always convert types from dto to the entity bch nkhaliw el abstraction and we follow the design pattern.
    @Override
    public CategoryProjectsDto save(CategoryProjectsDto dto) {
        validator.validate(dto);
        CategoryProjects categoryProjects = CategoryProjectsDto.toEntity(dto);
        repository.save(categoryProjects);
        return CategoryProjectsDto.fromEntity(categoryProjects);
    }

    @Override
    public List<CategoryProjectsDto> findAll() {
        return repository.findAll().stream()
                .map(CategoryProjectsDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryProjectsDto findById(Long id) {

        return repository.findById(id).map(CategoryProjectsDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("no category with the provided id : " + id));
    }

    @Override
    public void delete(Long id) {
        //check before delete

        repository.deleteById(id);
    }
}
