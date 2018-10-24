package expensemanager.expense;

import java.util.Set;

public interface ExpenseService {

    ExpenseDto create(ExpenseCreateDto expenseCreateDto);

    ExpenseDto update(ExpenseDto expenseDto);

    void delete(Long id);

    ExpenseDto findById(Long id);

    Set<ExpenseDto> findByCategoryId(Long categoryId);

    Set<ExpenseDto> findAll();
}
