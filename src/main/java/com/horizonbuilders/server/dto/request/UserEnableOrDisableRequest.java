package com.horizonbuilders.server.dto.request;

public record UserEnableOrDisableRequest(
        int id,
        boolean enable
) {
}
