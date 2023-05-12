package com.horizonbuilders.server.controller;

import com.horizonbuilders.server.dto.response.GlobalTypeResponse;
import com.horizonbuilders.server.model.inventory.GlobalType;
import com.horizonbuilders.server.service.GlobalTypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level =  AccessLevel.PRIVATE)
@RequestMapping("/global-type")
public class GlobalTypeController {
    final GlobalTypeService globalTypeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GlobalType createGlobalType(@RequestParam("name") String name) {
        return globalTypeService.createGlobalType(name);
    }

    @GetMapping
    public List<GlobalTypeResponse> fetchAllGlobalTypes() {
        return globalTypeService.fetchAllGlobalTypes();
    }
}
