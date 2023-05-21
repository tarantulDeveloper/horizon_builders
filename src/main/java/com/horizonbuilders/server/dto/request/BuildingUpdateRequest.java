package com.horizonbuilders.server.dto.request;

public record BuildingUpdateRequest(
        int id,
        String dateStart,
        String dateEnd,
        String name,
        String description,
        int numberOfFloors,
        int numberOfApartments,
        String address,
        String state
) {
}
