package expensemanager.user;

import expensemanager.common.CommonEntityToDtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends CommonEntityToDtoMapper<UserDto, UserCreateDto, UserUpdateDto, User> {

}
