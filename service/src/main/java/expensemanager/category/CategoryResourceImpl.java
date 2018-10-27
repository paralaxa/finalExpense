package expensemanager.category;

import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/v1")
public class CategoryResourceImpl implements CategoryResource {

    private CategoryService categoryService;

    public CategoryResourceImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @Override
    @PostMapping("category")
    public CategoryDto create(@RequestBody CategoryCreateDto categoryCreateDto) {
        return categoryService.create(categoryCreateDto);
    }

    @Override
    @PutMapping("category/{id}")
    public CategoryDto update(@RequestBody CategoryUpdateDto categoryUpdateDto, @PathVariable("id") Long id) {
        categoryUpdateDto.setId(id);
        return categoryService.update(categoryUpdateDto);
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
