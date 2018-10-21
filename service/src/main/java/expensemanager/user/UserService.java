package expensemanager.user;

public interface UserService {
    UserDto create(UserDto userDto);

    UserDto update(UserDto userDto);

    void delete(Long id);

    UserDto getById(Long id);
}
