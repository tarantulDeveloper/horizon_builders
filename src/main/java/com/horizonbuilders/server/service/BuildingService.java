package com.horizonbuilders.server.service;

import com.horizonbuilders.server.dto.request.BuildingRequest;
import com.horizonbuilders.server.model.User;
import com.horizonbuilders.server.model.building.Building;
import com.horizonbuilders.server.model.enums.EState;

import java.util.List;

public interface BuildingService {
    List<Building> getAllBuildings();
//    Building addBuilding(int employeeId, Building building);

//    Building updateBuilding(int employeeId,BuildingRequest updateBuilding);

    void deleteBuildingById(int id);

    Building findBuildingById(int id);
}
