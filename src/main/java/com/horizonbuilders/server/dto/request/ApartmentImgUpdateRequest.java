package com.horizonbuilders.server.dto.request;

import org.springframework.web.multipart.MultipartFile;

public record ApartmentImgUpdateRequest(
        int apartmentId,
        MultipartFile img
) {
}
