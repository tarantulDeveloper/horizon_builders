package com.horizonbuilders.server.service;

import com.horizonbuilders.server.dto.request.UserUpdateRequest;
import com.horizonbuilders.server.dto.response.UserInfoResponse;

import java.util.List;

public interface UserService {

    UserInfoResponse addNewUser(int positionId, String username, String password);

    UserInfoResponse findUserById(int id);

    UserInfoResponse updateUser(UserUpdateRequest request, int userId);

}
