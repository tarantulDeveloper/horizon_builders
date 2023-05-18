package com.horizonbuilders.server.controller;

import com.horizonbuilders.server.dto.request.GlobalTypeRequest;
import com.horizonbuilders.server.dto.request.GlobalTypeUpdateRequest;
import com.horizonbuilders.server.model.inventory.GlobalType;
import com.horizonbuilders.server.service.GlobalTypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/api/global-type")
public class GlobalTypeController {
    final GlobalTypeService globalTypeService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public GlobalType addGlobalType(@RequestBody GlobalTypeRequest request) {
        return globalTypeService.createGlobalType(request.name());
    }

    @PreAuthorize("hasAnyAuthority({'ADMIN', 'WORKER'})")
    @GetMapping
    public Page<GlobalType> getAllGlobalTypes(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return globalTypeService.getAllGlobalTypes(pageNo, pageSize, sortBy);
    }

    @PreAuthorize("hasAnyAuthority({'ADMIN', 'WORKER'})")
    @GetMapping("/{globalTypeId}")
    public GlobalType getGlobalTypeById(@PathVariable("globalTypeId") int globalTypeId) {
        return globalTypeService.getById(globalTypeId);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{globalTypeId}")
    public void deleteById(@PathVariable("globalTypeId") int globalTypeId) {
        globalTypeService.deleteById(globalTypeId);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public GlobalType updateGlobalType(@RequestBody GlobalTypeUpdateRequest request) {
        return globalTypeService.updateGlobalType(request, request.id());
    }
}
