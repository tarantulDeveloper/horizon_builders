package com.horizonbuilders.server.controller;

import com.horizonbuilders.server.dto.request.PositionRequest;
import com.horizonbuilders.server.dto.request.PositionUpdateRequest;
import com.horizonbuilders.server.model.Position;
import com.horizonbuilders.server.service.PositionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/api/position")
public class PositionController {
    final PositionService positionService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public Position addPosition(
            @RequestBody PositionRequest request) {
        return positionService.addPosition(request.name(), request.salary());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public Page<Position> getAllPositions(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return positionService.getAllPositions(pageNo, pageSize, sortBy);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{positionId}")
    public void deleteById(@PathVariable("positionId") int positionId) {
        positionService.deletePositionById(positionId);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public Position updatePosition(
            @RequestBody PositionUpdateRequest request) {
        return positionService.updatePosition(request.name(), request.salary(), request.id());
    }


    @GetMapping("/{positionId}")
    public Position getById(@PathVariable("positionId") int positionId) {
        return positionService.getPositionById(positionId);
    }
}
