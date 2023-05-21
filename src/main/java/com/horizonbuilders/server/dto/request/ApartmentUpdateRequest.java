package com.horizonbuilders.server.dto.request;


public record ApartmentUpdateRequest(
        int id,
        int roomNumber,
        double area,
        double pricePerArea,
        String status,
        int buildingId
) {
}
