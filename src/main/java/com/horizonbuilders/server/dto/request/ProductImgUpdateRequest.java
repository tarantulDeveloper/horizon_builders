package com.horizonbuilders.server.dto.request;

import org.springframework.web.multipart.MultipartFile;

public record ProductImgUpdateRequest(
        int productId,
        MultipartFile img
) {
}
