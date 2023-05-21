package com.horizonbuilders.server.service.impl;

import com.horizonbuilders.server.dto.request.ApartmentImgUpdateRequest;
import com.horizonbuilders.server.dto.request.ApartmentRequest;
import com.horizonbuilders.server.dto.request.ApartmentUpdateRequest;
import com.horizonbuilders.server.dto.response.ApartmentResponse;
import com.horizonbuilders.server.exception.BadRequestException;
import com.horizonbuilders.server.exception.ResourceNotFoundException;
import com.horizonbuilders.server.mapper.ApartmentMapper;
import com.horizonbuilders.server.model.building.Apartment;
import com.horizonbuilders.server.model.building.Building;
import com.horizonbuilders.server.model.enums.EStatus;
import com.horizonbuilders.server.repository.ApartmentRepository;
import com.horizonbuilders.server.repository.projections.ApartmentListView;
import com.horizonbuilders.server.service.ApartmentService;
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
public class ApartmentServiceImpl implements ApartmentService {
    final ApartmentRepository apartmentRepository;
    final CloudinaryService cloudinaryService;
    final BuildingService buildingService;
    final ApartmentMapper apartmentMapper;

    @Override
    public Apartment addApartment(ApartmentRequest request) {
        if(request.roomNumber() < 0 || request.area() < 0 || request.pricePerArea() < 0 ){
            throw new BadRequestException("Number of rooms,room area and price per area should be more than 0!");
        }
        double price = request.area()* request.pricePerArea();
        Apartment apartment = Apartment.builder()
                .roomNumber(request.roomNumber())
                .area(request.area())
                .pricePerArea(request.pricePerArea())
                .price(price)
                .imgUrl(cloudinaryService.upload(request.img()))
                .status(EStatus.FREE)
                .building(buildingService.getBuildingById(request.buildingId()))
                .build();
        return apartmentRepository.save(apartment);
    }

    @Override
    public Page<ApartmentListView> getAllApartments(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo,pageSize, Sort.by(sortBy).descending());
        return apartmentRepository.findAllProjectedBy(pageable);
    }

    @Override
    public ApartmentResponse getApartmentById(int apartmentId) {
        return apartmentRepository.findById(apartmentId).map(apartmentMapper::toApartmentResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Apartment not found!"));
    }

    @Override
    public Apartment updateApartment(ApartmentUpdateRequest request) {
        Apartment apartment = apartmentRepository.findById(request.id())
                .orElseThrow(() -> new ResourceNotFoundException("Apartment not found!"));
        if(request.roomNumber() < 0 || request.area() < 0 || request.pricePerArea() < 0 ){
            throw new BadRequestException("Number of rooms,room area and price per area should be more than 0!");
        }
        double price = request.area()* request.pricePerArea();
        apartment.setRoomNumber(request.roomNumber());
        apartment.setArea(request.area());
        apartment.setPricePerArea(request.pricePerArea());
        apartment.setPrice(price);
        apartment.setStatus(EStatus.valueOf(request.status()));
        apartment.setBuilding(buildingService.getBuildingById(request.buildingId()));
        return apartmentRepository.save(apartment);
    }

    @Override
    public Apartment updateApartmentImg(ApartmentImgUpdateRequest request) {
        Apartment apartment = apartmentRepository.findById(request.apartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Apartment not found!"));
        apartment.setImgUrl(cloudinaryService.upload(request.img()));
        return apartmentRepository.save(apartment);
    }
}
