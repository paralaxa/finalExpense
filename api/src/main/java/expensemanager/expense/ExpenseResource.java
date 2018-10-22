package expensemanager.expense;

import java.util.Set;

public interface ExpenseResource {

    Set<ExpenseDto> getAll();

    ExpenseDto create(ExpenseDto expenseDto);

    void delete(Long id);

    ExpenseDto update(ExpenseDto expenseDto);

    Set<ExpenseDto> getByCategoryId(Long categoryId);
}
