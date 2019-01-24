package expensemanager.category;

import expensemanager.common.BusinessException;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.sql.rowset.serial.SerialException;
import javax.validation.Valid;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
@Validated
public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao;
    private CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryDao categoryDao, CategoryMapper categoryMapper) {
        this.categoryDao = categoryDao;
        this.categoryMapper = categoryMapper;
    }

    @Override
    @CachePut(value = "categories", key = "#result.id")//, unless = "#result.size>100")
    public CategoryDto create(CategoryCreateDto categoryCreateDto) {
        Category category = categoryMapper.entityFromCreateDto(categoryCreateDto);
        return categoryMapper.dtoFromEntity(categoryDao.save(category));
    }

    @Override
    @CacheEvict(value = "categories", key = "#categoryUpdateDto.id")
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
    @Transactional(readOnly = true)
    @Cacheable(value = "categories")
    public CategoryDto findById(Long id) {
        System.out.println("finding by id");
        return categoryMapper.dtoFromEntity(categoryDao.getOne(id));
    }

    @Override
    @Transactional(readOnly = true) //ak je tu druha Readonly TX, neflushne sa!
    @Cacheable(value = "categories")
    public Set<CategoryDto> findAll() {
        return null;
    }
}
