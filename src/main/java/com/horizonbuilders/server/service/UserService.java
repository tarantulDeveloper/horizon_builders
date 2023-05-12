package com.horizonbuilders.server.service;

import com.horizonbuilders.server.dto.response.UserInfoResponse;
import com.horizonbuilders.server.dto.response.UserResponse;
import com.horizonbuilders.server.model.User;

import java.util.List;

public interface UserService {

    UserResponse addNewUser(int positionId, String username, String password);

    UserInfoResponse findUserById(int id);

}
