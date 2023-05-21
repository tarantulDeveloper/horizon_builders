package com.horizonbuilders.server.controller;

import com.horizonbuilders.server.dto.request.BuildingImgUpdateRequest;
import com.horizonbuilders.server.dto.request.BuildingRequest;
import com.horizonbuilders.server.dto.request.BuildingUpdateRequest;
import com.horizonbuilders.server.dto.response.BuildingResponse;
import com.horizonbuilders.server.service.BuildingService;
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
@RequestMapping("/api/building")
public class BuildingController {
    final BuildingService buildingService;

    @GetMapping
    @SecurityRequirements
    public Page<BuildingResponse> getAllBuildings(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return buildingService.getAllBuildings(pageNo, pageSize, sortBy);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public BuildingResponse addBuilding(@ModelAttribute BuildingRequest request) {
        return buildingService.addBuilding(request);
    }

    @GetMapping("/{buildingId}")
    @SecurityRequirements
    public BuildingResponse getBuildingById(@PathVariable("buildingId") int buildingId) {
        return buildingService.getById(buildingId);
    }

    @Operation(description = """
            "state" can be COMPLETED, INPROCESS, SUSPEND or ESTIMATED
            """)
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public BuildingResponse updateBuilding(@RequestBody BuildingUpdateRequest request) {
        return buildingService.updateBuilding(request);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping(value = "/photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public BuildingResponse updateBuildingImg(@ModelAttribute BuildingImgUpdateRequest request) {
        return buildingService.updateBuildingImg(request);
    }
}
