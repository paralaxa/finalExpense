package expensemanager.expense;

import expensemanager.category.Category;
import expensemanager.common.BusinessException;
import expensemanager.user.User;
import expensemanager.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseDao expenseDao;
    private ExpenseMapper expenseMapper;
    @Autowired
    private UserService userService;
    @PersistenceContext
    private EntityManager entityManager;

    public ExpenseServiceImpl(ExpenseDao expenseDao, ExpenseMapper expenseMapper) {
        this.expenseDao = expenseDao;
        this.expenseMapper = expenseMapper;
    }



    @Override
//    @Secured("ROLE_USER")
    public ExpenseDto create(ExpenseCreateDto expenseCreateDto) {
        Expense expense = expenseMapper.entityFromCreateDto(expenseCreateDto);
        Category category = entityManager.getReference(Category.class, expenseCreateDto.getCategoryId());
        UserDetails user = userService.loadUserByUsername(((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        expense.setCreator((User)user);
        expense.setCategory(category);
        return expenseMapper.dtoFromEntity(expenseDao.save(expense));
    }

    @Override
    @CacheEvict(key = "#expenseUpdateDto.id")
    public ExpenseDto update(ExpenseUpdateDto expenseUpdateDto) {
        Optional<Expense> expenseById = expenseDao.findById(expenseUpdateDto.getId());
        if (expenseById.isPresent()) {
            expenseMapper.enrichEntityWithUpdateDto(expenseById.get(), expenseUpdateDto);
            return expenseMapper.dtoFromEntity(expenseById.get());
        }
        throw new BusinessException("Expense not found by id:" + expenseUpdateDto.getId());
    }

    @Override
    public void delete(Long id) {
        Expense expense = new Expense();
        expense.setId(id);
        expenseDao.delete(expense);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable
    public ExpenseDto findById(Long id) {
        System.out.println("here");
        return expenseMapper.dtoFromEntity(expenseDao.getOne(id));
    }

    @Override
    @Transactional(readOnly = true) //N+1!!!
    public List<ExpenseDto> findByCategoryId(Long categoryId) {
        return expenseDao.findByCategory_Id(categoryId).stream().map(expenseMapper::dtoFromEntity).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    @Secured("MAKAC")
    public List<ExpenseDto> findAll() { //!!!!N+1 query!!!!!
        return expenseDao.findAll().stream().map(expenseMapper::dtoFromEntity).collect(Collectors.toList());
    }


}
