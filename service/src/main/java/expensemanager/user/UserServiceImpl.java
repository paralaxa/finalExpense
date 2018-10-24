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

    @Override
    public UserDto create(UserCreateDto userCreateDto) {
        User userToBeCreated = userMapper.entityFromCreateDto(userCreateDto);
        User userCreated = userDao.save(userToBeCreated);
        return userMapper.dtoFromEntity(userCreated);
    }

    @Override
    public UserDto update(UserDto userDto) {
        User userToBeCreated = userMapper.entityFromDto(userDto);
        User userCreated = userDao.save(userToBeCreated);
        return userMapper.dtoFromEntity(userCreated);
    }

    @Override
    public void delete(Long id) {
        User user = new User();
        user.setId(id);

        userDao.delete(user);
    }

    @Override
    public UserDto findById(Long id) {
        Optional<User> byId = userDao.findById(id);
        User user = byId.orElse(null);
        return userMapper.dtoFromEntity(user);


    }
}
