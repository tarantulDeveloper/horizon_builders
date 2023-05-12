package com.horizonbuilders.server.dto.response;

import com.horizonbuilders.server.model.Position;

public record UserInfoResponse(
        String username,
        String firstName,
        String lastName,
        String photoUrl,
        String phoneNumber,
        String address,
        Position position
) {
}
