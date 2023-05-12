package com.horizonbuilders.server.dto.request;

import org.springframework.web.multipart.MultipartFile;

public record UserUpdateRequest(
        String firstName,
        String lastName,
        MultipartFile photo,
        String phoneNumber,
        String address
) {
}
