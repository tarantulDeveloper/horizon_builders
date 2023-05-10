package com.horizonbuilders.server.repository;

import com.horizonbuilders.server.model.inventory.SubType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubTypeRepository extends JpaRepository<SubType, Integer> {
}
