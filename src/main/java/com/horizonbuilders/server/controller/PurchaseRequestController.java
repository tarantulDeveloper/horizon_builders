package com.horizonbuilders.server.controller;

import com.horizonbuilders.server.dto.request.PurchaseCreateRequest;
import com.horizonbuilders.server.model.PurchaseRequest;
import com.horizonbuilders.server.service.PurchaseRequestService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/api/purchase-request")
public class PurchaseRequestController {
    final PurchaseRequestService purchaseRequestService;

    @PostMapping
    public PurchaseRequest createPurchaseRequest(@RequestBody PurchaseCreateRequest request) {
        return purchaseRequestService.createPurchase(request);
    }
}
