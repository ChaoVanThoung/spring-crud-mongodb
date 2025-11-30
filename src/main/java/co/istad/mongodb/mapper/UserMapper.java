package co.istad.mongodb.mapper;

import co.istad.mongodb.domain.User;
import co.istad.mongodb.dto.UserRequest;
import co.istad.mongodb.dto.UserResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse toUserResponse(User user);

    User fromUserRequest(UserRequest userRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromUserUpdateRequestPartially(UserRequest userRequest, @MappingTarget User user);

}
