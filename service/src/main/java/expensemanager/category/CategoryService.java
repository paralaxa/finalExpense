package expensemanager.category;


import javax.validation.Valid;
import java.util.Set;

public interface CategoryService {

    CategoryDto create(@Valid CategoryCreateDto categoryCreateDto);

    CategoryDto update(CategoryUpdateDto categoryUpdateDto);

    void delete(Long id);

    CategoryDto findById(Long id);

    Set<CategoryDto> findAll();
}
