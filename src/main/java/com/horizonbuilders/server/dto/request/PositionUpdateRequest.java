package com.horizonbuilders.server.dto.request;

public record PositionUpdateRequest(
        int id,
        String name,
        double salary
) {
}
