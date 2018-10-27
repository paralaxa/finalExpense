package expensemanager.expense;

import expensemanager.common.BusinessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseDao expenseDao;
    private ExpenseMapper expenseMapper;

    public ExpenseServiceImpl(ExpenseDao expenseDao, ExpenseMapper expenseMapper) {
        this.expenseDao = expenseDao;
        this.expenseMapper = expenseMapper;
    }

    @Override
    public ExpenseDto create(ExpenseCreateDto expenseCreateDto) {
        Expense expense = expenseMapper.entityFromCreateDto(expenseCreateDto);
        return expenseMapper.dtoFromEntity(expenseDao.save(expense));
    }

    @Override
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
    public ExpenseDto findById(Long id) {
        return expenseMapper.dtoFromEntity(expenseDao.getOne(id));
    }

    @Override
    public List<ExpenseDto> findByCategoryId(Long categoryId) {
        return expenseDao.findByCategory_Id(categoryId).stream().map(expense -> expenseMapper.dtoFromEntity(expense)).collect(Collectors.toList());
    }

    @Override
    public List<ExpenseDto> findAll() { //!!!!N+1 query!!!!!
        return expenseDao.findAll().stream().map(expense -> expenseMapper.dtoFromEntity(expense)).collect(Collectors.toList());
    }
}
