package expensemanager.common;

import org.mapstruct.MappingTarget;

public interface CommonEntityToDtoMapper<TD, TC, TU, TE> {
    TE entityFromDto(TC dto);

    TD dtoFromEntity(TE entity);

    TE entityFromCreateDto(TC c);

    void enrichEntityWithUpdateDto(@MappingTarget  TE e, TU c);
}
