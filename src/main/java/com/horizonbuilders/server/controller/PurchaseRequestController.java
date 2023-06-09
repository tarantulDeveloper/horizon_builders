package com.horizonbuilders.server.controller;

import com.horizonbuilders.server.dto.request.PurchaseCreateRequest;
import com.horizonbuilders.server.model.PurchaseRequest;
import com.horizonbuilders.server.service.PurchaseRequestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/api/purchase-request")
public class PurchaseRequestController {
    final PurchaseRequestService purchaseRequestService;

    @SecurityRequirements
    @PostMapping
    @Operation(description = "все могут выполнять этот запрос, даже неавторизованные")
    public PurchaseRequest createPurchaseRequest(@RequestBody PurchaseCreateRequest request) {
        return purchaseRequestService.createPurchase(request);
    }

    @GetMapping
    @Operation(description = "Нужно обладать ролями 'ADMIN' или 'SUPERVISOR'")
    public Page<PurchaseRequest> getAllPurchaseRequests(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return purchaseRequestService.getAllPurchaseRequests(pageNo, pageSize, sortBy);
    }

    @GetMapping("/{purchaseId}")
    @Operation(description = "Нужно обладать ролями 'ADMIN' или 'SUPERVISOR'")
    public PurchaseRequest getPurchaseRequestById(@PathVariable("purchaseId") int purchaseId) {
        return purchaseRequestService.getPurchaseRequestById(purchaseId);
    }

    @DeleteMapping("/{purchaseId}")
    @Operation(description = "Нужно обладать ролями 'ADMIN' или 'SUPERVISOR'")
    public void deletePurchaseRequestById(@PathVariable("purchaseId") int purchaseId) {
        purchaseRequestService.deletePurchaseRequestById(purchaseId);
    }
}
