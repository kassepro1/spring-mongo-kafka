package fr.whitedev.springmongo.Controller;


import fr.whitedev.springmongo.domaine.Category;
import fr.whitedev.springmongo.domaine.dto.CategoryDto;
import fr.whitedev.springmongo.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/api")
public class CategoryController {

    private final CategoryService categoryService;


    @PostMapping("/categories")
    public Category createCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.createCategory(categoryDto);
    }

    @GetMapping("/categories")
    public List<Category> findAll(){
        return categoryService.findAll();
    }
}
