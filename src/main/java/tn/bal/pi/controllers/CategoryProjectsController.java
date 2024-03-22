package tn.bal.pi.controllers;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.bal.pi.entities.CategoryProjects;
import tn.bal.pi.services.ICategoryProjectsService;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PUBLIC)
@RequestMapping("category-project")
public class CategoryProjectsController {
    @Autowired
    ICategoryProjectsService iCategoryProjectsService;
    @PostMapping
    public CategoryProjects addCategory(@RequestBody CategoryProjects c){
        return iCategoryProjectsService.addCategory(c);
    }
    @GetMapping
    public List<CategoryProjects> getAllCategories(){
        return iCategoryProjectsService.getAllCategories();
    }
    @GetMapping("/{id}")
    public CategoryProjects getCategoryById( @PathVariable  Long id ){
            return  iCategoryProjectsService.getCategoryById(id);
    }
    @PostMapping("/update")
    public CategoryProjects updateCategory(@RequestBody CategoryProjects c){
        return iCategoryProjectsService.updateCategory(c);
    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
         iCategoryProjectsService.deleteCategoryById(id);
    }

}
