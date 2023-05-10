package com.horizonbuilders.server.repository;

import com.horizonbuilders.server.model.inventory.GlobalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GlobalTypeRepository extends JpaRepository<GlobalType, Integer> {
    boolean existsByName(String name);
}
