package com.horizonbuilders.server.service.impl;

import com.horizonbuilders.server.dto.request.UserUpdateRequest;
import com.horizonbuilders.server.dto.response.UserInfoResponse;
import com.horizonbuilders.server.exception.AlreadyExistException;
import com.horizonbuilders.server.exception.ResourceNotFoundException;
import com.horizonbuilders.server.exception.UserNotFoundException;
import com.horizonbuilders.server.mapper.UserMapper;
import com.horizonbuilders.server.model.Position;
import com.horizonbuilders.server.model.User;
import com.horizonbuilders.server.model.enums.ERole;
import com.horizonbuilders.server.repository.UserRepository;
import com.horizonbuilders.server.service.CloudinaryService;
import com.horizonbuilders.server.service.PositionService;
import com.horizonbuilders.server.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {
    final UserRepository userRepository;
    final UserMapper userMapper;
    final PasswordEncoder passwordEncoder;
    final PositionService positionService;
    final CloudinaryService cloudinaryService;

    @Override
    public UserInfoResponse addNewUser(int positionId, String username, String password) {
        if (userRepository.existsByUsername(username)) {
            throw new AlreadyExistException("This username already exist!");
        }
        User user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .enabled(true)
                .position(positionService.findPositionById(positionId))
                .roles(Set.of(ERole.WORKER))
                .build();
        return userMapper.toUserInfoResponse(userRepository.save(user));
    }

    @Override
    public UserInfoResponse findUserById(int id) {
        return userMapper.toUserInfoResponse(userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found!")));
    }

    @Override
    public UserInfoResponse updateUser(UserUpdateRequest request, int userId) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        user.setPhoneNumber(request.phoneNumber());
        user.setAddress(request.address());

        return userMapper.toUserInfoResponse(userRepository.save(user));
    }

    @Override
    public Page<UserInfoResponse> getAllUsers(
            int pageNo, int pageSize, String sortBy
    ) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        return userRepository.findAll(pageable).map(userMapper::toUserInfoResponse);
    }

    @Override
    public UserInfoResponse updatePhoto(MultipartFile photo, int userId) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        user.setPhotoUrl(cloudinaryService.upload(photo));

        return userMapper.toUserInfoResponse(userRepository.save(user));
    }

    @Override
    public UserInfoResponse updatePassword(String password, int userId) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        user.setPassword(passwordEncoder.encode(password));
        return userMapper.toUserInfoResponse(userRepository.save(user));
    }
}
