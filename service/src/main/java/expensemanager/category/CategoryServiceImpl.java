package expensemanager.category;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao;
    private CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryDao categoryDao, CategoryMapper categoryMapper) {
        this.categoryDao = categoryDao;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryDto create(CategoryCreateDto categoryCreateDto) {
        Category category = categoryMapper.entityFromCreateDto(categoryCreateDto);
        return categoryMapper.dtoFromEntity(categoryDao.save(category));
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto) {
        Category category = categoryMapper.entityFromDto(categoryDto);
        return categoryMapper.dtoFromEntity(categoryDao.save(category));
    }

    @Override
    public void delete(Long id) {
        Category category = new Category();
        category.setId(id);
        categoryDao.delete(category);
    }

    @Override
    public CategoryDto findById(Long id) {
        return categoryMapper.dtoFromEntity(categoryDao.getOne(id));
    }

    @Override
    public Set<CategoryDto> findAll() {
        return null;
    }
}
