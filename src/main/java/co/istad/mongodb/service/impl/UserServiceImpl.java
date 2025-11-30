package co.istad.mongodb.service.impl;

import co.istad.mongodb.domain.User;
import co.istad.mongodb.dto.UserRequest;
import co.istad.mongodb.dto.UserResponse;
import co.istad.mongodb.mapper.UserMapper;
import co.istad.mongodb.repository.UserRepository;
import co.istad.mongodb.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponse> findAll() {

        List<User> users = userRepository.findAll();

        return users.stream().map(userMapper::toUserResponse).toList();
    }

    @Override
    public UserResponse findById(String id) {

        User user = userRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"User id " + id + " not found"
                )
        );
        return userMapper.toUserResponse(user);
    }

    @Override
    public UserResponse createNew(UserRequest userRequest) {
        User user = userMapper.fromUserRequest(userRequest);
        User savedUser = userRepository.save(user);
        return userMapper.toUserResponse(savedUser);
    }

    @Override
    public UserResponse updateById(String id,UserRequest userRequest) {

        User user = userRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"user id: "  + id + " not found"
                )
        );
        userMapper.fromUserUpdateRequestPartially(userRequest,user);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public void deleteById(String id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"user id: "  + id + " not found"
                )
        );
        userRepository.delete(user);
    }
}
