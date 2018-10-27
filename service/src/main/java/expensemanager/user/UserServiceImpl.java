package expensemanager.user;

import expensemanager.common.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
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
    public UserDto update(UserUpdateDto userUpdateDto) { //nerobim savE!!!
        Optional<User> userById = userDao.findById(userUpdateDto.getId());
        if (userById.isPresent()) {
            userMapper.enrichEntityWithUpdateDto(userById.get(), userUpdateDto);
            return userMapper.dtoFromEntity(userById.get());
//             pre security ukazat, co je filter a ako funguje?
        }
        throw new BusinessException("User not found for id:" + userUpdateDto.getId());

    }

    @Override
    public void delete(Long id) {
        User user = new User();
        user.setId(id);

        userDao.delete(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto findById(Long id) {
        Optional<User> byId = userDao.findById(id);
        User user = byId.orElse(null);
        return userMapper.dtoFromEntity(user);


    }
}
