package expensemanager.user;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userFromUserDto(UserDto userDto);
    UserDto userDtoFromUser(User user);
}
