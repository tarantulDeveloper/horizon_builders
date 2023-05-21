package com.horizonbuilders.server.service.impl;

import com.horizonbuilders.server.dto.request.PurchaseCreateRequest;
import com.horizonbuilders.server.model.PurchaseRequest;
import com.horizonbuilders.server.repository.PurchaseRequestRepository;
import com.horizonbuilders.server.service.PurchaseRequestService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PurchaseRequestServiceImpl implements PurchaseRequestService {
    final PurchaseRequestRepository purchaseRequestRepository;
    @Override
    public PurchaseRequest createPurchase(PurchaseCreateRequest request) {
        return purchaseRequestRepository.save(
                PurchaseRequest.builder()
                        .customerName(request.customerName())
                        .phoneNumber(request.phoneNumber())
                        .message(request.message())
                        .build()
        );
    }
}
