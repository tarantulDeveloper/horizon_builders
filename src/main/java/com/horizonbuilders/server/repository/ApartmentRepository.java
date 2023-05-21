package com.horizonbuilders.server.repository;

import com.horizonbuilders.server.model.building.Apartment;
import com.horizonbuilders.server.repository.projections.ApartmentListView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentRepository extends JpaRepository<Apartment,Integer> {
    Page<ApartmentListView> findAllProjectedBy(Pageable pageable);
}
