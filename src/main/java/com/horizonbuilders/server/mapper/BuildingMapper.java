package com.horizonbuilders.server.mapper;

import com.horizonbuilders.server.dto.response.BuildingResponse;
import com.horizonbuilders.server.model.building.Building;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BuildingMapper {
    BuildingResponse toBuildingResponse(Building building);
}
