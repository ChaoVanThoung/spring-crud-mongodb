package co.istad.mongodb.service;

import co.istad.mongodb.domain.User;
import co.istad.mongodb.dto.UserRequest;
import co.istad.mongodb.dto.UserResponse;

import java.util.List;

public interface UserService {

    // find all
    List<UserResponse> findAll();

    // find by id
    UserResponse findById(String id);

    // create new
    UserResponse createNew(UserRequest userRequest);

    // update
    UserResponse updateById(String id, UserRequest userRequest);

    // delete
    void deleteById(String id);


}
