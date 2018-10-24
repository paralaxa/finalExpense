package expensemanager.category;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/v1")
public class CategoryResourceImpl implements CategoryResource {

    private CategoryService categoryService;

    public CategoryResourceImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @Override
    public CategoryDto create(CategoryCreateDto categoryCreateDto) {
        return categoryService.create(categoryCreateDto);
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto) {
        return categoryService.update(categoryDto);
    }

    @Override
    @GetMapping("category")
    public Set<CategoryDto> getAll() {
        return categoryService.findAll();
    }

    @Override
    @GetMapping("category/{id}")
    public CategoryDto getById(@PathVariable("id") Long id) {
        return categoryService.findById(id);
    }


}
