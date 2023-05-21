package com.horizonbuilders.server.dto.request;

import com.horizonbuilders.server.model.building.Building;
import org.springframework.web.multipart.MultipartFile;

public record ApartmentRequest(
        int roomNumber,
        double area,
        double pricePerArea,
        MultipartFile img,
        int buildingId
) {
}
