package com.horizonbuilders.server.dto.response;


public record BuildingResponse(
        int id,
        String dateStart,
        String dateEnd,
        String name,
        String description,
        int numberOfFloors,
        int numberOfApartments,
        String address,
        String imgUrl,
        String state
) {
}
