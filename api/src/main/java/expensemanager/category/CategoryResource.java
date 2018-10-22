package expensemanager.category;

import java.util.Set;

public interface CategoryResource {
    Set<CategoryDto> getAll();

    CategoryDto getById(Long id);
}
