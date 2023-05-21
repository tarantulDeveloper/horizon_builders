package com.horizonbuilders.server.service.impl;

import com.horizonbuilders.server.dto.request.BuildingImgUpdateRequest;
import com.horizonbuilders.server.dto.request.BuildingRequest;
import com.horizonbuilders.server.dto.request.BuildingUpdateRequest;
import com.horizonbuilders.server.dto.response.BuildingResponse;
import com.horizonbuilders.server.exception.BadRequestException;
import com.horizonbuilders.server.exception.ResourceNotFoundException;
import com.horizonbuilders.server.mapper.BuildingMapper;
import com.horizonbuilders.server.model.building.Building;
import com.horizonbuilders.server.model.enums.EState;
import com.horizonbuilders.server.repository.BuildingRepository;
import com.horizonbuilders.server.service.BuildingService;
import com.horizonbuilders.server.service.CloudinaryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BuildingServiceImpl implements BuildingService {
    final BuildingRepository buildingRepository;
    final CloudinaryService cloudinaryService;
    final BuildingMapper buildingMapper;

    @Override
    public Page<BuildingResponse> getAllBuildings(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        return buildingRepository.findAll(pageable).map(buildingMapper::toBuildingResponse);
    }

    @Override
    public BuildingResponse addBuilding(BuildingRequest request) {
        if (request.numberOfApartments() < 0 || request.numberOfFloors() < 0) {
            throw new BadRequestException("Number of floors or number of apartments should be more than 0!");
        }
        Building building = Building.builder()
                .dateStart(request.dateStart())
                .dateEnd(request.dateEnd())
                .name(request.name())
                .description(request.description())
                .numberOfFloors(request.numberOfFloors())
                .numberOfApartments(request.numberOfApartments())
                .address(request.address())
                .imgUrl(cloudinaryService.upload(request.img()))
                .state(EState.INPROCESS)
                .build();
        return buildingMapper.toBuildingResponse(buildingRepository.save(building));
    }

    @Override
    public BuildingResponse getById(int buildingId) {
        return buildingRepository.findById(buildingId).map(buildingMapper::toBuildingResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Building not found!"));

    }

    @Override
    public BuildingResponse updateBuilding(BuildingUpdateRequest request) {
        Building building = buildingRepository.findById(request.id())
                .orElseThrow(() -> new ResourceNotFoundException("Building not found!"));
        if (request.numberOfApartments() < 0 || request.numberOfFloors() < 0) {
            throw new BadRequestException("Number of floors or number of apartments should be more than 0!");
        }
        building.setDateStart(request.dateStart());
        building.setDateEnd(request.dateEnd());
        building.setName(request.name());
        building.setDescription(request.description());
        building.setNumberOfFloors(request.numberOfFloors());
        building.setNumberOfApartments(request.numberOfApartments());
        building.setAddress(request.address());
        building.setState(EState.valueOf(request.state()));
        return buildingMapper.toBuildingResponse(buildingRepository.save(building));
    }

    @Override
    public BuildingResponse updateBuildingImg(BuildingImgUpdateRequest request) {
        Building building = buildingRepository.findById(request.buildingId())
                .orElseThrow(() -> new ResourceNotFoundException("Building not found!"));
        building.setImgUrl(cloudinaryService.upload(request.img()));
        return buildingMapper.toBuildingResponse(buildingRepository.save(building));
    }

}
