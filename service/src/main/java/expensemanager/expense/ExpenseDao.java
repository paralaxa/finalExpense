package expensemanager.expense;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseDao extends JpaRepository<Expense, Long> {

}
