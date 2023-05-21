package com.horizonbuilders.server.service;

import com.horizonbuilders.server.dto.request.ApartmentImgUpdateRequest;
import com.horizonbuilders.server.dto.request.ApartmentRequest;
import com.horizonbuilders.server.dto.request.ApartmentUpdateRequest;
import com.horizonbuilders.server.dto.response.ApartmentResponse;
import com.horizonbuilders.server.model.building.Apartment;
import com.horizonbuilders.server.repository.projections.ApartmentListView;
import org.springframework.data.domain.Page;

public interface ApartmentService {
    Apartment addApartment(ApartmentRequest request);

    Page<ApartmentListView> getAllApartments(int pageNo, int pageSize, String sortBy);

    ApartmentResponse getApartmentById(int apartmentId);

    Apartment updateApartment(ApartmentUpdateRequest request);

    Apartment updateApartmentImg(ApartmentImgUpdateRequest request);
}
