package expensemanager.expense;


import expensemanager.category.CategoryDto;
import expensemanager.user.UserDto;

public class ExpenseDto {
    private Long id;
    private UserDto creator;
    private String description;
    private CategoryDto category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getCreator() {
        return creator;
    }

    public void setCreator(UserDto creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }
}
