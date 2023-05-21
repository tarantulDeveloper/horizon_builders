package com.horizonbuilders.server.service.impl;

import com.horizonbuilders.server.dto.request.PurchaseCreateRequest;
import com.horizonbuilders.server.exception.ResourceNotFoundException;
import com.horizonbuilders.server.model.PurchaseRequest;
import com.horizonbuilders.server.repository.PurchaseRequestRepository;
import com.horizonbuilders.server.service.PurchaseRequestService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Override
    public Page<PurchaseRequest> getAllPurchaseRequests(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        return purchaseRequestRepository.findAll(pageable);
    }

    @Override
    public PurchaseRequest getPurchaseRequestById(int purchaseId) {
        return purchaseRequestRepository.findById(purchaseId).orElseThrow(
                () -> new ResourceNotFoundException("Purchase request not found!")
        );
    }
}
