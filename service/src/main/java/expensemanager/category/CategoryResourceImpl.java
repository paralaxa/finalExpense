package expensemanager.category;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
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

        System.out.println("getting cat by id");
        return categoryService.findById(id);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> hanldeConstraintViolation(
            ConstraintViolationException ex) {
        return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
    }
}
