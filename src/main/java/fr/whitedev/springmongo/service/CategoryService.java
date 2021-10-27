package fr.whitedev.springmongo.service;

import fr.whitedev.springmongo.domaine.Category;
import fr.whitedev.springmongo.domaine.dto.CategoryDto;
import fr.whitedev.springmongo.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category createCategory(CategoryDto category){
        Category cat = new Category();
        cat.setName(category.getName());
        return categoryRepository.save(cat);
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }


}
