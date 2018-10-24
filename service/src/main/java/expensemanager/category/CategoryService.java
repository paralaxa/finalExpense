package expensemanager.category;


import java.util.Set;

public interface CategoryService {

    CategoryDto create(CategoryCreateDto categoryCreateDto);

    CategoryDto update(CategoryDto categoryDto);

    void delete(Long id);

    CategoryDto findById(Long id);

    Set<CategoryDto> findAll();
}
