package expensemanager.resource;

import expensemanager.user.UserDto;
import expensemanager.user.UserResource;
import expensemanager.user.UserService;
import org.springframework.web.bind.annotation.*;


@RestController

public class UserResourceImpl implements UserResource {

    private UserService userService;

    public UserResourceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @RequestMapping("user")
    @PostMapping(consumes = "application/json")
    public UserDto create(@RequestBody UserDto userDto) {
        return userService.create(userDto);
    }

    @Override
    @RequestMapping("user")
    @PutMapping(consumes = "application/json")
    public UserDto update(@RequestBody UserDto userDto) {
        return userService.update(userDto);
    }

    @Override
    @RequestMapping("user")
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    @Override
    @RequestMapping("user")
    @GetMapping("{id}")
    public UserDto getById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }
}
