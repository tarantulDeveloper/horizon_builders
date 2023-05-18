package com.horizonbuilders.server.dto.request;

public record ProductUpdateRequest(
        int id,
        String name,
        int quantity,
        double price,
        int subTypeId
) {
}
