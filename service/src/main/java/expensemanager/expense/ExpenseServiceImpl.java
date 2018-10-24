package expensemanager.expense;

import org.springframework.stereotype.Service;

import java.util.Set;

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
    public ExpenseDto update(ExpenseDto expenseDto) {
        Expense expense = expenseMapper.entityFromDto(expenseDto);
        return expenseMapper.dtoFromEntity(expenseDao.save(expense));
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
    public Set<ExpenseDto> findByCategoryId(Long categoryId) {
        return null;
    }

    @Override
    public Set<ExpenseDto> findAll() {
        return null;
    }
}
