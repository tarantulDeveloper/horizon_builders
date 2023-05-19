package com.horizonbuilders.server.dto.response;

import com.horizonbuilders.server.model.Position;

import java.util.List;

public record UserInfoResponse(
        int id,
        String username,
        String firstName,
        String lastName,
        String photoUrl,
        String phoneNumber,
        String address,
        boolean active,
        Position position,
        List<String> roles
) {
}
