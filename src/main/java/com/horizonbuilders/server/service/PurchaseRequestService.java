package com.horizonbuilders.server.service;

import com.horizonbuilders.server.dto.request.PurchaseCreateRequest;
import com.horizonbuilders.server.model.PurchaseRequest;
import org.springframework.data.domain.Page;

public interface PurchaseRequestService {
    PurchaseRequest createPurchase(PurchaseCreateRequest request);

    Page<PurchaseRequest> getAllPurchaseRequests(int pageNo, int pageSize, String sortBy);

    PurchaseRequest getPurchaseRequestById(int purchaseId);
}
