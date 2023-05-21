package com.horizonbuilders.server.repository;

import com.horizonbuilders.server.model.PurchaseRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRequestRepository extends JpaRepository<PurchaseRequest, Integer> {
}
