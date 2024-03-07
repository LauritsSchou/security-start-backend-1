package dat3.recipe.service;

import dat3.recipe.entity.Category;
import dat3.recipe.entity.Recipe;
import dat3.recipe.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<String> getAllCategories() {
        List<dat3.recipe.entity.Category> categories =  categoryRepository.findAll();
        //Convert from list of Categories to DTO-type, list of Strings
        return categories.stream().map((c)->new String(c.getName())).toList();
    }
    //public dat3.recipe.entity.RecipeDto addCategory(RecipeDto request) {
       // RecipeDto newCategory = new RecipeDto();

        //categoryRepository.save(newCategory);
}

