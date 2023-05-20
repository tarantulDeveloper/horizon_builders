package com.horizonbuilders.server.service;

import com.horizonbuilders.server.dto.request.GlobalTypeUpdateRequest;
import com.horizonbuilders.server.model.inventory.GlobalType;
import com.horizonbuilders.server.repository.projections.GlobalTypeListView;
import org.springframework.data.domain.Page;

public interface GlobalTypeService {
    GlobalType createGlobalType(String name);

    Page<GlobalTypeListView> getAllGlobalTypes(int pageNo, int pageSize, String sortBy);

    GlobalType getById(int globalTypeId);

    void deleteById(int globalTypeId);

    GlobalType updateGlobalType(GlobalTypeUpdateRequest request, int id);
}
