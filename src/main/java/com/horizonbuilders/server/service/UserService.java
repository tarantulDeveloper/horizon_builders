package com.horizonbuilders.server.service;

import com.horizonbuilders.server.dto.request.UserUpdateRequest;
import com.horizonbuilders.server.dto.response.UserInfoResponse;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    UserInfoResponse addNewUser(int positionId, String username, String password);

    UserInfoResponse findUserById(int id);

    UserInfoResponse updateUser(UserUpdateRequest request, int userId);

    Page<UserInfoResponse> getAllUsers(int pageNo, int pageSize, String sortBy);

    UserInfoResponse updatePhoto(MultipartFile photo, int userId);

    UserInfoResponse updatePassword(String password, int userId);
}
