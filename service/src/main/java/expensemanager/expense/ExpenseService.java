package expensemanager.expense;

import java.util.List;

public interface ExpenseService {

    ExpenseDto create(ExpenseCreateDto expenseCreateDto);

    ExpenseDto update(ExpenseUpdateDto expenseUpdateDto);

    void delete(Long id);

    ExpenseDto findById(Long id);

    List<ExpenseDto> findByCategoryId(Long categoryId);

    List<ExpenseDto> findAll();
}
