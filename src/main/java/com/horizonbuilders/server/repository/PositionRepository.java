package com.horizonbuilders.server.repository;

import com.horizonbuilders.server.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {
    boolean existsByName(String name);

}
