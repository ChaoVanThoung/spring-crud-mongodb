package co.istad.mongodb.controller;

import co.istad.mongodb.dto.FilterDto;
import co.istad.mongodb.dto.UserRequest;
import co.istad.mongodb.dto.UserResponse;
import co.istad.mongodb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public Page<UserResponse> findAll(@RequestParam(required = false, defaultValue = "0") int page, @RequestParam(required = false, defaultValue = "25") int size) {

        return userService.findAll(page, size);
    }

    @PostMapping("/filter")
    public Page<UserResponse> filterUsers(@RequestBody FilterDto filterDto,
                                          @RequestParam(required = false, defaultValue = "0") int page,
                                          @RequestParam(required = false, defaultValue = "25") int size) {
        return userService.filterByUsers(filterDto, page, size);
    }

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable String id) {
        return userService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserResponse createNewUser(@RequestBody UserRequest userRequest) {
        return userService.createNew(userRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public UserResponse updateUserById(@PathVariable String id, @RequestBody UserRequest userRequest) {
        return userService.updateById(id, userRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable String id) {
        userService.deleteById(id);
    }

}
