package expensemanager.expense;

import expensemanager.common.CommonEntityToDtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpenseMapper extends CommonEntityToDtoMapper<ExpenseDto, ExpenseCreateDto, Expense> {

}
