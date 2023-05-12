package com.horizonbuilders.server.controller;

import com.horizonbuilders.server.model.building.Building;
import com.horizonbuilders.server.service.BuildingService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/building")
public class BuildingContoller {
    BuildingService buildingService;

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
