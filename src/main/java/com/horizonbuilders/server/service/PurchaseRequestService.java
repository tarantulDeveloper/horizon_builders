package com.horizonbuilders.server.service;

import com.horizonbuilders.server.dto.request.PurchaseCreateRequest;
import com.horizonbuilders.server.model.PurchaseRequest;

public interface PurchaseRequestService {
    PurchaseRequest createPurchase(PurchaseCreateRequest request);
}
