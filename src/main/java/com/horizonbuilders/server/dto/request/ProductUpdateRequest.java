package com.horizonbuilders.server.dto.request;

import org.springframework.web.multipart.MultipartFile;

public record ProductUpdateRequest(
        int id,
        String name,
        int quantity,
        double price,
        int subTypeId
) {
}
