package expensemanager.category;


import java.util.Set;

public interface CategoryService {

    CategoryDto create(CategoryCreateDto categoryCreateDto);

    CategoryDto update(CategoryUpdateDto categoryUpdateDto);

    void delete(Long id);

    CategoryDto findById(Long id);

    Set<CategoryDto> findAll();
}
