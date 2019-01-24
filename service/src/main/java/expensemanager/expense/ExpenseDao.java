package expensemanager.expense;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpenseDao extends JpaRepository<Expense, Long> {
    List<Expense> findByCategory_Id(Long categoryId);

    @Query("select  e from Expense e join fetch e.category")
    List<Expense> findAll();
}
