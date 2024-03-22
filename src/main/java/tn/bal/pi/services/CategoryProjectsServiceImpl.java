package tn.bal.pi.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.bal.pi.entities.CategoryProjects;
import tn.bal.pi.repositories.CategoryProjectsRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryProjectsServiceImpl implements ICategoryProjectsService {
    private  final CategoryProjectsRepository categoryProjectsRepository;
    @Override
    public List<CategoryProjects> getAllCategories() {
        return categoryProjectsRepository.findAll();
    }

    @Override
    public CategoryProjects getCategoryById(Long id) {
        return categoryProjectsRepository.findById(id).get();
    }

    @Override
    public CategoryProjects addCategory(CategoryProjects c) {
        return categoryProjectsRepository.save(c);
    }

    @Override
    public CategoryProjects updateCategory(CategoryProjects c) {
        return categoryProjectsRepository.save(c);
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryProjectsRepository.deleteById(id);
    }
}
