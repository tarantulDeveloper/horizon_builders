package com.horizonbuilders.server.mapper;

import com.horizonbuilders.server.dto.request.BuildingRequest;
import com.horizonbuilders.server.model.building.Building;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BuildingMapper {
    Building toModel(BuildingRequest dto);
}
