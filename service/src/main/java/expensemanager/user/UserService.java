package expensemanager.user;

import javax.validation.Valid;
public interface UserService {
    UserDto create(@Valid UserCreateDto userCreateDto);

    UserDto update(UserUpdateDto userUpdateDto);

    void delete(Long id);

    UserDto findById(Long id);
}
