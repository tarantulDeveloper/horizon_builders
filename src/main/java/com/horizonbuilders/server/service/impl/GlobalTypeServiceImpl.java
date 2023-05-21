package com.horizonbuilders.server.service.impl;

import com.horizonbuilders.server.dto.request.GlobalTypeUpdateRequest;
import com.horizonbuilders.server.exception.BadRequestException;
import com.horizonbuilders.server.exception.ResourceNotFoundException;
import com.horizonbuilders.server.model.inventory.GlobalType;
import com.horizonbuilders.server.repository.GlobalTypeRepository;
import com.horizonbuilders.server.repository.projections.GlobalTypeListView;
import com.horizonbuilders.server.service.GlobalTypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
    public Page<GlobalTypeListView> getAllGlobalTypes(
            int pageNo, int pageSize, String sortBy
    ) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        return globalTypeRepository.findAllProjectedBy(pageable);
    }

    @Override
    public GlobalType getById(int globalTypeId) {
        return globalTypeRepository.findById(globalTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("Global Type not found!"));
    }

    @Override
    public void deleteById(int globalTypeId) {
        GlobalType globalType = globalTypeRepository.findById(globalTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("Global type not found!"));
        globalTypeRepository.deleteById(globalTypeId);
    }

    @Override
    public GlobalType updateGlobalType(GlobalTypeUpdateRequest request, int id) {
        GlobalType updateGlobalType = globalTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Global type not found!"));
        updateGlobalType.setName(request.name());
        return globalTypeRepository.save(updateGlobalType);
    }


}
