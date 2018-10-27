package expensemanager.expense;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/v1")
public class ExpenseResourceImpl implements ExpenseResource {
    private ExpenseService expenseService;

    public ExpenseResourceImpl(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @Override
    @GetMapping("expense")
    public List<ExpenseDto> getAll() {
        return expenseService.findAll();
    }

    @Override
    @PostMapping("expense")
    public ExpenseDto create(@RequestBody ExpenseCreateDto expenseCreateDto) {
        return expenseService.create(expenseCreateDto);
    }

    @Override
    @DeleteMapping("expense/{id}")
    public void delete(@PathVariable("id") Long id) {
        expenseService.delete(id);
    }

    @Override
    @PutMapping("expense/{id}")
    public ExpenseDto update(@RequestBody ExpenseUpdateDto expenseUpdateDto,@PathVariable("id") Long id) {
        expenseUpdateDto.setId(id);
        return expenseService.update(expenseUpdateDto);
    }

    @Override
    @GetMapping("category/{categoryId}/expense")
    public List<ExpenseDto> getByCategoryId(@PathVariable("categoryId") Long categoryId) {
        return expenseService.findByCategoryId(categoryId);
    }
}
