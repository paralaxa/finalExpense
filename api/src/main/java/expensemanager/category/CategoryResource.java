package expensemanager.category;

import java.util.Set;

public interface CategoryResource {

    CategoryDto create(CategoryCreateDto categoryCreateDto);

    CategoryDto update(CategoryDto categoryDto);

    Set<CategoryDto> getAll();

    CategoryDto getById(Long id);
}
