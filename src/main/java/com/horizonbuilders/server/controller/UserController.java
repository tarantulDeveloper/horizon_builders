package com.horizonbuilders.server.controller;

import com.horizonbuilders.server.dto.request.UserPasswordUpdateRequest;
import com.horizonbuilders.server.dto.request.UserPhotoUpdateRequest;
import com.horizonbuilders.server.dto.request.UserRequest;
import com.horizonbuilders.server.dto.request.UserUpdateRequest;
import com.horizonbuilders.server.dto.response.UserInfoResponse;
import com.horizonbuilders.server.model.User;
import com.horizonbuilders.server.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/api")
public class UserController {
    final UserService userService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/user")
    public UserInfoResponse addUser(@RequestBody UserRequest request) {
        return userService.addNewUser(request.positionId(), request.username(), request.password());
    }

    @GetMapping("/me")
    public UserInfoResponse getMe(@AuthenticationPrincipal User user) {
        return userService.findUser(user);
    }

    @PutMapping("/settings/user")
    public UserInfoResponse updateUser(@RequestBody UserUpdateRequest request,
                                       @AuthenticationPrincipal User user) {
        return userService.updateUser(request, user);
    }

    @PutMapping(value = "/settings/photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public UserInfoResponse updatePhoto(@ModelAttribute UserPhotoUpdateRequest request,
                                        @AuthenticationPrincipal User user) {
        return userService.updatePhoto(request.photo(), user);
    }

    @PutMapping("/settings/password")
    public UserInfoResponse updatePassword(@RequestBody UserPasswordUpdateRequest request,
                                           @AuthenticationPrincipal User user) {
        return userService.updatePassword(request.password(), user);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/user")
    public Page<UserInfoResponse> getAllUsers(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return userService.getAllUsers(pageNo, pageSize, sortBy);
    }


}
