package com.horizonbuilders.server.repository;

import com.horizonbuilders.server.model.inventory.GlobalType;
import com.horizonbuilders.server.repository.projections.GlobalTypeListView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GlobalTypeRepository extends JpaRepository<GlobalType, Integer> {
    boolean existsByName(String name);

    Page<GlobalTypeListView> findAllProjectedBy(Pageable pageable);
}
