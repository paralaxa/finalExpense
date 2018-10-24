package expensemanager.user;

public interface UserService {
    UserDto create(UserCreateDto userCreateDto);

    UserDto update(UserDto userDto);

    void delete(Long id);

    UserDto findById(Long id);
}
