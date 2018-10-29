package expensemanager.user;

import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;


import javax.validation.ConstraintViolationException;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceNoSpringTest {


    @Mock
    private UserDao userDao;

    private UserService userService;
    private UserMapper userMapper = new UserMapperImpl();

    @Before
    public void setUp() throws Exception {
        userService = new UserServiceImpl(userDao, userMapper);
        when(userDao.save(any()))
                .thenAnswer(invocation ->
                {
                    User user = invocation.getArgument(0);
                    user.setId(1l);
                    return user;
                });
    }


    @Test
    public void weCanCreateUser() {
        UserCreateDto userCreateDto = new UserCreateDto();
        userCreateDto.setUsername("username");
        userCreateDto.setPassword("password");
        UserDto userDto = userService.create(userCreateDto);
        assertEquals(userDto.getUsername(), userCreateDto.getUsername());
    }

}