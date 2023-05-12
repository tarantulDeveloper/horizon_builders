package com.horizonbuilders.server.service.impl;

import com.horizonbuilders.server.dto.response.UserResponse;
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

//    @Override
//    public User getUserById(int id) {
//        return userRepository.findById(id)
//                .orElseThrow(()-> new ResourceNotFoundException("No such user"));
//    }
    @Override
    public UserResponse addNewUser(int positionId,String username,String password) {
        User user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .enabled(true)
                .position(positionService.findPositionById(positionId))
                .roles(Set.of(ERole.WORKER))
                .build();
        return userMapper.toUserResponse(userRepository.save(user));
    }
}
