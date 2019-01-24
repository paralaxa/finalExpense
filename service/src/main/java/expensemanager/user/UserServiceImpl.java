package expensemanager.user;

import expensemanager.common.BusinessException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Optional;

@Service
@Transactional
@Validated
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private UserMapper userMapper;
    @Value("${user.admin.pswd}")
    private String adminPswd;
    @Value("${user.admin.username}")
    private String adminUsername;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDao userDao, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto create(@Valid UserCreateDto userCreateDto) {
        User userToBeCreated = userMapper.entityFromCreateDto(userCreateDto);
        Role userRole = new Role();
        if (adminUsername.equals(userCreateDto.getUsername()) && adminPswd.equals(userCreateDto.getPassword())) {
            userRole.setAuthority("ROLE_ADMIN");
        } else {
            userRole.setAuthority("ROLE_USER");
        }
        userToBeCreated.setRole(userRole);
        userToBeCreated.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));
        if (loadUserByUsername(userCreateDto.getUsername()) == null) {
            User userCreated = userDao.save(userToBeCreated);
        return userMapper.dtoFromEntity(userCreated);
        }
        throw new RuntimeException("User already exist");
    }

    @Override
    public UserDto update(UserUpdateDto userUpdateDto) { //nerobim savE!!!
        Optional<User> userById = userDao.findById(userUpdateDto.getId());
        if (userById.isPresent()) {
            userMapper.enrichEntityWithUpdateDto(userById.get(), userUpdateDto);
            return userMapper.dtoFromEntity(userById.get());
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

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.findByUsername(username);
    }
}
