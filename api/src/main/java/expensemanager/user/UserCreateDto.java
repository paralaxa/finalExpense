package expensemanager.user;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class UserCreateDto implements Serializable {
    @NotNull
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public String toString() {
        return "UserCreateDto{" +
                ", username='" + username + '\'' +
                '}';
    }
}
