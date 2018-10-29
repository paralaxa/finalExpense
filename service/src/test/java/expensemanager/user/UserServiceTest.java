package expensemanager.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void weCanCreateUser() {
        UserCreateDto userCreateDto = new UserCreateDto();
        userCreateDto.setUsername("username");
        userCreateDto.setPassword("password");
        UserDto userDto = userService.create(userCreateDto);
        assertEquals(userDto.getUsername(), userCreateDto.getUsername());
    }
     @Test(expected = ConstraintViolationException.class)
    public void weGetExpectionWhenUsernameIsEmpty() {
        UserCreateDto userCreateDto = new UserCreateDto();
        userCreateDto.setPassword("password");
        UserDto userDto = userService.create(userCreateDto);
        assertEquals(userDto.getUsername(), userCreateDto.getUsername());
    }
}