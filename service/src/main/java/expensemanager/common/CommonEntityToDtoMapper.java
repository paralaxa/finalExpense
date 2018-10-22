package expensemanager.common;

public interface CommonEntityToDtoMapper<T, E> {
    E entityFromDto(T dto);

    T dtoFromENtity(E entity);
}
