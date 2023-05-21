package com.horizonbuilders.server.controller;

import com.horizonbuilders.server.dto.request.ApartmentImgUpdateRequest;
import com.horizonbuilders.server.dto.request.ApartmentRequest;
import com.horizonbuilders.server.dto.request.ApartmentUpdateRequest;
import com.horizonbuilders.server.dto.response.ApartmentResponse;
import com.horizonbuilders.server.model.building.Apartment;
import com.horizonbuilders.server.repository.projections.ApartmentListView;
import com.horizonbuilders.server.service.ApartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/api/apartment")
public class ApartmentController {
    final ApartmentService apartmentService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Apartment addApartment(@ModelAttribute ApartmentRequest request){
        return apartmentService.addApartment(request);
    }

    @SecurityRequirements
    @GetMapping
    public Page<ApartmentListView> getAllApartments(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ){
        return apartmentService.getAllApartments(pageNo,pageSize,sortBy);
    }

    @SecurityRequirements
    @GetMapping("/{apartmentId}")
    public ApartmentResponse getApartmentById(@PathVariable("apartmentId") int apartmentId){
        return apartmentService.getApartmentById(apartmentId);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(description = """
            "status" can be SOLD, FREE or RESERVED
            """)
    @PutMapping
    public Apartment updateApartment(@RequestBody ApartmentUpdateRequest request){
        return apartmentService.updateApartment(request);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping(value = "/photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Apartment updateApartmentImg(@ModelAttribute ApartmentImgUpdateRequest request){
        return apartmentService.updateApartmentImg(request);
    }
}
