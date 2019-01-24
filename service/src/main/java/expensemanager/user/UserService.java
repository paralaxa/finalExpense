package expensemanager.user;

import org.springframework.security.core.userdetails.UserDetailsService;

import javax.validation.Valid;
public interface UserService extends UserDetailsService{
    UserDto create(@Valid UserCreateDto userCreateDto);

    UserDto update(UserUpdateDto userUpdateDto);

    void delete(Long id);

    UserDto findById(Long id);


}
