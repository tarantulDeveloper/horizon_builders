package com.horizonbuilders.server.service;

import com.horizonbuilders.server.dto.request.SubTypeUpdateRequest;
import com.horizonbuilders.server.model.inventory.SubType;
import org.springframework.data.domain.Page;

public interface SubTypeService {
    SubType addSubType(String name, int globalTypeId);

    SubType getById(int subTypeId);

    void deleteById(int subTypeId);

    SubType updateSubType(SubTypeUpdateRequest request, int id);
}
