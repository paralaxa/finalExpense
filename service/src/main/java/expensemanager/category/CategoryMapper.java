package expensemanager.category;

import expensemanager.common.CommonEntityToDtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends CommonEntityToDtoMapper<CategoryDto,CategoryCreateDto,CategoryUpdateDto , Category> {

}
