package com.horizonbuilders.server.dto.request;

import org.springframework.web.multipart.MultipartFile;

public record BuildingImgUpdateRequest(
        int buildingId,
        MultipartFile img
) {
}
