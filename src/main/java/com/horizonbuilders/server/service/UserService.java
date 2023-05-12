package com.horizonbuilders.server.service;

import com.horizonbuilders.server.dto.response.UserResponse;

public interface UserService {

    UserResponse addNewUser(int positionId, String username, String password);

}
