package com.horizonbuilders.server.service;

import com.horizonbuilders.server.dto.request.UserRequest;
import com.horizonbuilders.server.dto.response.UserResponse;
import com.horizonbuilders.server.model.User;

public interface UserService {

    UserResponse addNewUser(int positionId,String username,String password);

}
