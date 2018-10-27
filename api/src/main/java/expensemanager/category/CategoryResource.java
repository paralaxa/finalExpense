package expensemanager.category;

import java.util.Set;

public interface CategoryResource {

    CategoryDto create(CategoryCreateDto categoryCreateDto);

    CategoryDto update(CategoryUpdateDto categoryUpdateDto, Long id);

    Set<CategoryDto> getAll();

    CategoryDto getById(Long id);
}
