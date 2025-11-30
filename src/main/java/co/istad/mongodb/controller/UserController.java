package co.istad.mongodb.controller;

import co.istad.mongodb.dto.UserRequest;
import co.istad.mongodb.dto.UserResponse;
import co.istad.mongodb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
   private final UserService userService;
    @GetMapping
    public List<UserResponse> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable String id){
        return userService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserResponse createNewUser(@RequestBody UserRequest userRequest){
        return userService.createNew(userRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public UserResponse updateUserById(@PathVariable String id, @RequestBody UserRequest userRequest){
        return userService.updateById(id, userRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable String id){
        userService.deleteById(id);
    }

}
