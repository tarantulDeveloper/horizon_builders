package com.horizonbuilders.server.dto.response;

import com.horizonbuilders.server.model.building.Building;

public record ApartmentResponse(
        int id,
        int roomNumber,
        double area,
        double pricePerArea,
        double price,
        String status,
        String imgUrl,
        BuildingShortResponse buildingShortResponse
) {
    public record BuildingShortResponse(
            int id,
            String name,
            String description,
            String address,
            String imgUrl,
            String state
    ){

    }
}
