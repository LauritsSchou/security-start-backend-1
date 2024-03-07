package dat3.recipe.api;

import dat3.recipe.service.CategoryService;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<String>> getAllCategories() {
        List<String> categories = categoryService.getAllCategories();

        CacheControl cacheControl = CacheControl.maxAge(60, TimeUnit.SECONDS).cachePublic();

        return ResponseEntity.ok()
                .cacheControl(cacheControl)
                .body(categories);
    }


}
