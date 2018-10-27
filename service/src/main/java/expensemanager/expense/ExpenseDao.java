package expensemanager.expense;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseDao extends JpaRepository<Expense, Long> {
    List<Expense> findByCategory_Id(Long categoryId);
}
