package tn.bal.pi.services;

import tn.bal.pi.entities.CategoryProjects;

import java.util.List;

public interface ICategoryProjectsService {
    List<CategoryProjects> getAllCategories();
    CategoryProjects getCategoryById(Long id);
    CategoryProjects addCategory(CategoryProjects c);
    CategoryProjects updateCategory(CategoryProjects c);
    void deleteCategoryById(Long id);
}
