package com.horizonbuilders.server.service;

import com.horizonbuilders.server.model.building.Building;

import java.util.List;

public interface BuildingService {
    List<Building> getAllBuildings();

    void deleteBuildingById(int id);

    Building findBuildingById(int id);

}
