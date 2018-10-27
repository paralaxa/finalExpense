package expensemanager.user;

public interface UserService {
    UserDto create(UserCreateDto userCreateDto);

    UserDto update(UserUpdateDto userUpdateDto);

    void delete(Long id);

    UserDto findById(Long id);
}
