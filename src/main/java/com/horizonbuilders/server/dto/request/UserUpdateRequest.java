package com.horizonbuilders.server.dto.request;

import org.springframework.web.multipart.MultipartFile;

public record UserUpdateRequest(
        int id,
        String firstName,
        String lastName,
        String phoneNumber,
        String address
) {
}
