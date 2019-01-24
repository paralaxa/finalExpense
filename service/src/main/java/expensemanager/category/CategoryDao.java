package expensemanager.category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Long> {
    Category findByIdBetween(Long id, Long id2);


}
