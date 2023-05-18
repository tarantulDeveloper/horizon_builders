package com.horizonbuilders.server.dto.request;

import org.springframework.web.multipart.MultipartFile;

public record ProductRequest(
        String name,
        int quantity,
        MultipartFile img,
        double price,
        int subTypeId
) {
}
