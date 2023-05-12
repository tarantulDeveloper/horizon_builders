package com.horizonbuilders.server.controller;

import com.horizonbuilders.server.dto.response.UserResponse;
import com.horizonbuilders.server.service.impl.UserServiceImpl;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/api/user")
public class UserController {
    final UserServiceImpl userService;

    @PostMapping
    public UserResponse addUser(@RequestParam("id") int positionId,
                                @RequestParam("username") String username,
                                @RequestParam("password") String password) {
        return userService.addNewUser(positionId, username, password);
    }
}
