package expensemanager.expense;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class ExpenseCreateDto implements Serializable {
    @JsonIgnore
    private Long creatorId;
    private String description;
    private Long categoryId;
    @JsonFormat(pattern="dd.MM.yyyy")
    private Date creation;
    private Float ammount;

    @JsonFormat(pattern="dd.MM.yyyy")
    public Date getCreation() {
        return creation;
    }
    @JsonFormat(pattern="dd.MM.yyyy")
    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public Float getAmmount() {
        return ammount;
    }

    public void setAmmount(Float ammount) {
        this.ammount = ammount;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
