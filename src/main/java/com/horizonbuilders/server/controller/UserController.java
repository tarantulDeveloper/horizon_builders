package com.horizonbuilders.server.controller;

import com.horizonbuilders.server.dto.request.UserPasswordUpdateRequest;
import com.horizonbuilders.server.dto.request.UserPhotoUpdateRequest;
import com.horizonbuilders.server.dto.request.UserRequest;
import com.horizonbuilders.server.dto.request.UserUpdateRequest;
import com.horizonbuilders.server.dto.response.UserInfoResponse;
import com.horizonbuilders.server.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/api/user")
public class UserController {
    final UserService userService;

    @PostMapping
    public UserInfoResponse addUser(@RequestBody UserRequest request) {
        return userService.addNewUser(request.positionId(), request.username(), request.password());
    }

    @GetMapping("/{userId}")
    public UserInfoResponse getById(@PathVariable("userId") int userId) {
        return userService.findUserById(userId);
    }

    @PutMapping
    public UserInfoResponse updateUser(@RequestBody UserUpdateRequest request) {
        return userService.updateUser(request, request.id());
    }

    @PutMapping(value = "/photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public UserInfoResponse updatePhoto(@ModelAttribute UserPhotoUpdateRequest request) {
        return userService.updatePhoto(request.photo(), request.userId());
    }

    @PutMapping("/password")
    public UserInfoResponse updatePassword(@RequestBody UserPasswordUpdateRequest request) {
        return userService.updatePassword(request.password(), request.userId());
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public Page<UserInfoResponse> getAllUsers(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return userService.getAllUsers(pageNo, pageSize, sortBy);
    }


}
