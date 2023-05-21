package com.horizonbuilders.server.dto.request;


import org.springframework.web.multipart.MultipartFile;

public record BuildingRequest(
        String dateStart,
        String dateEnd,
        String name,
        String description,
        int numberOfFloors,
        int numberOfApartments,
        String address,
        MultipartFile img
) {
}
