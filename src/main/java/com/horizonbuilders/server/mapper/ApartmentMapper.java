package com.horizonbuilders.server.mapper;

import com.horizonbuilders.server.dto.response.ApartmentResponse;
import com.horizonbuilders.server.model.building.Apartment;
import com.horizonbuilders.server.model.building.Building;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ApartmentMapper {
    @Mapping(target = "buildingShortResponse", source = "apartment.building", qualifiedByName = "toShortBuildingResponse")
    ApartmentResponse toApartmentResponse(Apartment apartment);

    @Named("toShortBuildingResponse")
    ApartmentResponse.BuildingShortResponse toShortBuildingResponse(Building building);
}
