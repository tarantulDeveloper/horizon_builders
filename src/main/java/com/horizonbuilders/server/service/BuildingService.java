package com.horizonbuilders.server.service;

import com.horizonbuilders.server.dto.request.BuildingImgUpdateRequest;
import com.horizonbuilders.server.dto.request.BuildingRequest;
import com.horizonbuilders.server.dto.request.BuildingUpdateRequest;
import com.horizonbuilders.server.dto.response.BuildingResponse;
import com.horizonbuilders.server.model.building.Building;
import org.springframework.data.domain.Page;

public interface BuildingService {
    Page<BuildingResponse> getAllBuildings(int pageNo, int pageSize, String sortBy);

    BuildingResponse addBuilding(BuildingRequest request);

    BuildingResponse getBuildingResponseById(int buildingId);

    BuildingResponse updateBuilding(BuildingUpdateRequest request);

    BuildingResponse updateBuildingImg(BuildingImgUpdateRequest request);

    Building getBuildingById(int buildingId);
}
