package com.horizonbuilders.server.dto.request;

import org.springframework.web.multipart.MultipartFile;

public record UserPhotoUpdateRequest(
        int userId,
        MultipartFile photo
) {
}
