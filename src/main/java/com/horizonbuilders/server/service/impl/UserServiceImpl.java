package com.horizonbuilders.server.service.impl;

import com.horizonbuilders.server.dto.response.UserInfoResponse;
import com.horizonbuilders.server.dto.response.UserResponse;
import com.horizonbuilders.server.exception.AlreadyExistException;
import com.horizonbuilders.server.exception.ResourceNotFoundException;
import com.horizonbuilders.server.mapper.UserMapper;
import com.horizonbuilders.server.model.User;
import com.horizonbuilders.server.model.enums.ERole;
import com.horizonbuilders.server.repository.UserRepository;
import com.horizonbuilders.server.service.PositionService;
import com.horizonbuilders.server.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {
    final UserRepository userRepository;
    final UserMapper userMapper;
    final PasswordEncoder passwordEncoder;
    final PositionService positionService;

    @Override
    public UserResponse addNewUser(int positionId, String username, String password) {
        if(userRepository.existsByUsername(username)){
            throw new AlreadyExistException("This username already exist!");
        }
        User user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .enabled(true)
                .position(positionService.findPositionById(positionId))
                .roles(Set.of(ERole.WORKER))
                .build();
        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public UserInfoResponse findUserById(int id) {
        return userMapper.toUserInfoResponse(userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User not found!")));
    }
}
