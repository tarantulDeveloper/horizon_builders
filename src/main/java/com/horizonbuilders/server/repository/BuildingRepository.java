package com.horizonbuilders.server.repository;

import com.horizonbuilders.server.model.building.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building,Integer> {
    Boolean existsByName(String name);
}
