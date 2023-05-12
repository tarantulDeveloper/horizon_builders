package com.horizonbuilders.server.controller;

import com.horizonbuilders.server.model.building.Building;
import com.horizonbuilders.server.service.impl.BuildingServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/building")
@RequiredArgsConstructor
public class BuildingContoller {
    @Autowired
    BuildingServiceImpl buildingService;

    @DeleteMapping("/{buildingId}")
    public void deleteById(@PathVariable("BuildingId") int id) {
        buildingService.deleteBuildingById(id);
    }

    @GetMapping
    public List<Building> fetchAllBuildings() {
        return buildingService.getAllBuildings();
    }

    @GetMapping("/{buildingId}")
    public Building getById(@PathVariable("buildingId") int id) {
        return buildingService.findBuildingById(id);
    }
}
