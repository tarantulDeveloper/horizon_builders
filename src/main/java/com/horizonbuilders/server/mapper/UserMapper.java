package com.horizonbuilders.server.mapper;

import com.horizonbuilders.server.dto.response.UserInfoResponse;
import com.horizonbuilders.server.dto.response.UserResponse;
import com.horizonbuilders.server.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse toUserResponse(User entity);

    UserInfoResponse toUserInfoResponse(User entity);
}
