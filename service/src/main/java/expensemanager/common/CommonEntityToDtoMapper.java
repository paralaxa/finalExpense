package expensemanager.common;

public interface CommonEntityToDtoMapper<T, C, E> {
    E entityFromDto(T dto);

    T dtoFromEntity(E entity);

    E entityFromCreateDto(C c);
}
