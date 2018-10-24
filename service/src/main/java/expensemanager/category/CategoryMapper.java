package expensemanager.category;

import expensemanager.common.CommonEntityToDtoMapper;
import expensemanager.user.User;
import expensemanager.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends CommonEntityToDtoMapper<CategoryDto,CategoryCreateDto,  Category> {

}
