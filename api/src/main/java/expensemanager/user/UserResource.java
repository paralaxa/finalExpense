package expensemanager.user;

public interface UserResource {
    UserDto create(UserCreateDto userCreateDto);

    UserDto update(UserDto userDto);

    void delete(Long id);

    UserDto getById(Long id);
}
