package com.horizonbuilders.server.controller;

import com.horizonbuilders.server.dto.response.UserInfoResponse;
import com.horizonbuilders.server.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/api/user")
public class UserController {
    final UserService userService;

    @PostMapping
    public UserInfoResponse addUser(@RequestParam("id") int positionId,
                                    @RequestParam("username") String username,
                                    @RequestParam("password") String password) {
        return userService.addNewUser(positionId, username, password);
    }

    @GetMapping("/{userId}")
    public UserInfoResponse getById(@PathVariable("userId") int userId) {
        return userService.findUserById(userId);
    }

//    @PutMapping("/{userId}")
//    public User
}
