package com.horizonbuilders.server.controller;

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
    public void createGlobalType(@RequestParam("name") String name) {
        globalTypeService.createGlobalType(name);
    }

    @GetMapping
    public List<GlobalType> fetchAllGlobalTypes() {
        return globalTypeService.fetchAllGlobalTypes();
    }
}
