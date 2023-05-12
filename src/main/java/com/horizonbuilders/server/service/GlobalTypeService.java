package com.horizonbuilders.server.service;

import com.horizonbuilders.server.dto.response.GlobalTypeResponse;
import com.horizonbuilders.server.model.inventory.GlobalType;

import java.util.List;

public interface GlobalTypeService {
    GlobalType createGlobalType(String name);

    List<GlobalTypeResponse> fetchAllGlobalTypes();
}
