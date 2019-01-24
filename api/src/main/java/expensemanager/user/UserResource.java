package expensemanager.user;

public interface UserResource {

    UserDto create(UserCreateDto userCreateDto);

    UserDto update(UserUpdateDto userUpdateDto, Long id);

    void delete(Long id);

    UserDto getById(Long id);
}
