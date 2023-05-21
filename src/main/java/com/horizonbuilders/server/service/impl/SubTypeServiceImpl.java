package com.horizonbuilders.server.service.impl;

import com.horizonbuilders.server.dto.request.SubTypeUpdateRequest;
import com.horizonbuilders.server.exception.AlreadyExistException;
import com.horizonbuilders.server.exception.ResourceNotFoundException;
import com.horizonbuilders.server.model.inventory.SubType;
import com.horizonbuilders.server.repository.SubTypeRepository;
import com.horizonbuilders.server.service.GlobalTypeService;
import com.horizonbuilders.server.service.SubTypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubTypeServiceImpl implements SubTypeService {
    final SubTypeRepository subTypeRepository;
    final GlobalTypeService globalTypeService;

    @Override
    public SubType addSubType(String name, int globalTypeId) {
        SubType subType = new SubType();
        subType.setName(name);
        subType.setGlobalType(globalTypeService.getById(globalTypeId));
        return subTypeRepository.save(subType);
    }

    @Override
    public SubType getById(int subTypeId) {
        return subTypeRepository.findById(subTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("Sub type not found!"));
    }

    @Override
    public void deleteById(int subTypeId) {
        SubType subType = subTypeRepository.findById(subTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("Sub type not found!"));
        subTypeRepository.deleteById(subTypeId);
    }

    @Override
    public SubType updateSubType(SubTypeUpdateRequest request, int id) {
        SubType updateSubType = subTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sub type not found!"));
        updateSubType.setName(request.name());
        updateSubType.setGlobalType(globalTypeService.getById(request.globalTypeId()));
        return subTypeRepository.save(updateSubType);
    }


}
