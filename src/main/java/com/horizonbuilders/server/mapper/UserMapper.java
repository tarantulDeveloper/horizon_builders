package com.horizonbuilders.server.mapper;

import com.horizonbuilders.server.dto.response.UserInfoResponse;
import com.horizonbuilders.server.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserInfoResponse toUserInfoResponse(User entity);

}
