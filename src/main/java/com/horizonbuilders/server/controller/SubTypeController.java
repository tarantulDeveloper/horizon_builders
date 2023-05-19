package com.horizonbuilders.server.controller;

import com.horizonbuilders.server.dto.request.SubTypeRequest;
import com.horizonbuilders.server.dto.request.SubTypeUpdateRequest;
import com.horizonbuilders.server.model.inventory.SubType;
import com.horizonbuilders.server.service.SubTypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/api/sub-type")
public class SubTypeController {
    final SubTypeService subTypeService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public SubType addSubType(@RequestBody SubTypeRequest request) {
        return subTypeService.addSubType(request.name(), request.globalTypeId());
    }

    @GetMapping
    public Page<SubType> getAllSubTypes(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return subTypeService.getAllSubTypes(pageNo, pageSize, sortBy);
    }

    @GetMapping("{subTypeId}")
    public SubType getSubTypeById(@PathVariable("subTypeId") int subTypeId) {
        return subTypeService.getById(subTypeId);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("{subTypeId}")
    public void deleteById(@PathVariable("subTypeId") int subTypeId) {
        subTypeService.deleteById(subTypeId);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public SubType updateSubType(@RequestBody SubTypeUpdateRequest request) {
        return subTypeService.updateSubType(request, request.id());
    }

}
