package com.horizonbuilders.server.service.impl;

import com.horizonbuilders.server.exception.BadRequestException;
import com.horizonbuilders.server.model.inventory.GlobalType;
import com.horizonbuilders.server.repository.GlobalTypeRepository;
import com.horizonbuilders.server.service.GlobalTypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GlobalTypeServiceImpl implements GlobalTypeService {
    final GlobalTypeRepository globalTypeRepository;

    @Override
    public GlobalType createGlobalType(String name) {
        if (globalTypeRepository.existsByName(name)) {
            throw new BadRequestException("Global type already exists!");
        }
        GlobalType globalType = new GlobalType();
        globalType.setName(name);
        globalTypeRepository.save(globalType);
        return globalType;
    }

    @Override
    public List<GlobalType> fetchAllGlobalTypes() {
        return globalTypeRepository.findAll();
    }
}
