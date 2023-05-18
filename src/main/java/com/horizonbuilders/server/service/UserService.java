package com.horizonbuilders.server.service;

import com.horizonbuilders.server.dto.request.UserUpdateRequest;
import com.horizonbuilders.server.dto.response.UserInfoResponse;
import com.horizonbuilders.server.model.User;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    UserInfoResponse addNewUser(int positionId, String username, String password);


    UserInfoResponse updateUser(UserUpdateRequest request, User user);

    Page<UserInfoResponse> getAllUsers(int pageNo, int pageSize, String sortBy);

    UserInfoResponse updatePhoto(MultipartFile photo, User user);

    UserInfoResponse updatePassword(String password, User user);

    UserInfoResponse findUser(User user);
}
