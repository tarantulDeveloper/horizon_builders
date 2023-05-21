package com.horizonbuilders.server.dto.request;

public record PurchaseCreateRequest(
        String customerName,
        String phoneNumber,
        String message
) {
}
