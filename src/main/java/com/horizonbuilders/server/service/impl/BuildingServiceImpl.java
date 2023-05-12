package com.horizonbuilders.server.service.impl;

import com.horizonbuilders.server.exception.ResourceNotFoundException;
import com.horizonbuilders.server.model.building.Building;
import com.horizonbuilders.server.repository.BuildingRepository;
import com.horizonbuilders.server.service.BuildingService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BuildingServiceImpl implements BuildingService {
    final BuildingRepository buildingRepository;

    @Override
    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }

    @Override
    public void deleteBuildingById(int id) {
        Building building = buildingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Building not found!"));
        buildingRepository.deleteById(id);
    }

    @Override
    public Building findBuildingById(int id) {
        return buildingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Building not found!"));
    }
}
