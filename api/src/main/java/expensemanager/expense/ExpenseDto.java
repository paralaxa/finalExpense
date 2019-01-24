package expensemanager.expense;


import expensemanager.category.CategoryDto;
import expensemanager.user.UserDto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class ExpenseDto implements Serializable {
    @NotNull
    private Long id;
    private UserDto creator;
    private String description;
    private CategoryDto category;
    private Date creation;
    private Float ammount;

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public Float getAmmount() {
        return ammount;
    }

    public void setAmmount(Float ammount) {
        this.ammount = ammount;
    }

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
