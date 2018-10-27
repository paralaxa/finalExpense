package expensemanager.category;

import expensemanager.common.BusinessException;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialException;
import java.util.Optional;
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
    public CategoryDto update(CategoryUpdateDto categoryUpdateDto) {
        Optional<Category> categoryById = categoryDao.findById(categoryUpdateDto.getId());
        if (categoryById.isPresent()) {
            categoryMapper.enrichEntityWithUpdateDto(categoryById.get(), categoryUpdateDto);
            return categoryMapper.dtoFromEntity(categoryById.get());
        }
        throw new BusinessException("Category not found for id:" + categoryUpdateDto.getId());
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
