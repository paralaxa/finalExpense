package expensemanager.user;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private UserMapper userMapper;

    public UserServiceImpl(UserDao userDao, UserMapper userMapper) {
        this.userDao = userDao;
        this.userMapper = userMapper;
    }

    public UserDto create(UserDto userDto) {
        User userToBeCreated = userMapper.userFromUserDto(userDto);
        User userCreated = userDao.save(userToBeCreated);
        return userMapper.userDtoFromUser(userCreated);
    }

    public UserDto update(UserDto userDto) {
        User userToBeCreated = userMapper.userFromUserDto(userDto);
        User userCreated = userDao.save(userToBeCreated);
        return userMapper.userDtoFromUser(userCreated);
    }

    public void delete(Long id) {
        User user = new User();
        user.setId(id);

        userDao.delete(user);
    }

    public UserDto getById(Long id) {
        Optional<User> byId = userDao.findById(id);
        User user = byId.orElse(null);
        return userMapper.userDtoFromUser(user);


    }
}
