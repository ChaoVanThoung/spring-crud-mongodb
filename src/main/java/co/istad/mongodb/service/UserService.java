package co.istad.mongodb.service;

import co.istad.mongodb.domain.User;
import co.istad.mongodb.dto.FilterDto;
import co.istad.mongodb.dto.UserRequest;
import co.istad.mongodb.dto.UserResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    // find all
    Page<UserResponse> findAll(int page, int size);

    // find by id
    UserResponse findById(String id);

    // create new
    UserResponse createNew(UserRequest userRequest);

    // update
    UserResponse updateById(String id, UserRequest userRequest);

    // delete
    void deleteById(String id);

    // filter user
    Page<UserResponse> filterByUsers(FilterDto filterDto, int page,int size);


}
