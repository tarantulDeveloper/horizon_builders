package com.horizonbuilders.server.dto.request;

import com.horizonbuilders.server.model.User;
import com.horizonbuilders.server.model.enums.EState;

public record BuildingRequest(
        int id,
        String name,
        int numOfFloors,
        String city,
        String address,
        String imgUrl,
        EState state,
        User user
) {
}
