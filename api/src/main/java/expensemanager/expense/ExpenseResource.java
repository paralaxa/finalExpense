package expensemanager.expense;

import java.util.Set;

public interface ExpenseResource {

    Set<ExpenseDto> getAll();

    ExpenseDto create(ExpenseCreateDto expenseCreateDto);

    void delete(Long id);

    ExpenseDto update(ExpenseDto expenseDto);

    Set<ExpenseDto> getByCategoryId(Long categoryId);
}
