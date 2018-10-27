package expensemanager.expense;

import java.util.List;

public interface ExpenseResource {

    List<ExpenseDto> getAll();

    ExpenseDto create(ExpenseCreateDto expenseCreateDto);

    void delete(Long id);

    ExpenseDto update(ExpenseUpdateDto expenseUpdateDto, Long id);

    List<ExpenseDto> getByCategoryId(Long categoryId);
}
