package expensemanager.expense;

import org.springframework.web.bind.annotation.*;

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
    public Set<ExpenseDto> getAll() {
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
    @PutMapping("expense")
    public ExpenseDto update(@RequestBody ExpenseDto expenseDto) {
        return expenseService.update(expenseDto);
    }

    @Override
    @GetMapping("category/{categoryId}/expense")
    public Set<ExpenseDto> getByCategoryId(@PathVariable("categoryId") Long categoryId) {
        return expenseService.findByCategoryId(categoryId);
    }
}
