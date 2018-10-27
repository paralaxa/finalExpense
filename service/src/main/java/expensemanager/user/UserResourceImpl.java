package expensemanager.user;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1")
public class UserResourceImpl implements UserResource {

    private UserService userService;

    public UserResourceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping("user")
    public UserDto create(@RequestBody UserCreateDto userCreateDto) {
        return userService.create(userCreateDto);
    }

    @Override
    @PutMapping("user/{id}")
    public UserDto update(@RequestBody UserUpdateDto userUpdateDto, @PathVariable("id") Long id) {
        userUpdateDto.setId(id);
        return userService.update(userUpdateDto);
    }

    @Override
    @DeleteMapping("user/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    @Override
    @GetMapping("user/{id}")
    public UserDto getById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }
}
