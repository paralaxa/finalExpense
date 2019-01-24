package expensemanager.category;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
public class CategoryCreateDto implements Serializable {
    @NotNull(message = "name cannot be null")
    private String name;
    @NotNull
    @Size(min=5, message = "description must have at least 5 characters")
    private String description;
    @JsonIgnore
    private Long creatorId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
