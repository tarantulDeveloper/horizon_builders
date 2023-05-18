package com.horizonbuilders.server.dto.request;

public record SubTypeUpdateRequest(
        int id,
        String name,
        int globalTypeId
) {
}
