package com.horizonbuilders.server.controller;

import com.horizonbuilders.server.dto.request.PositionRequest;
import com.horizonbuilders.server.model.Position;
import com.horizonbuilders.server.service.PositionService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/position")
public class PositionController {
    final PositionService positionService;

    @PostMapping
    public Position addPosition(
//            @NotNull @NotBlank @RequestParam("name") String name,
//            @RequestParam("salary") double salary
            @RequestBody PositionRequest request) throws IOException {
        return positionService.addPosition(request.name(), request.salary());
    }

    @GetMapping
    public List<Position> fetchAllPositions() {
        return positionService.getAllPositions();
    }

    @DeleteMapping("/{positionId}")
    public void deleteById(@PathVariable("positionId") int id) throws IOException {
        positionService.deletePositionById(id);
    }

    @PutMapping("/{positionId}")
    public void updateById(
            @PathVariable("positionId") int id,
            @RequestParam("name") String name,
            @RequestParam("salary") double salary) {
        positionService.updatePosition(name, salary, id);
    }

    @GetMapping("/{positionId}")
    public Position getById(@PathVariable("positionId") int id) {
        return positionService.findPositionById(id);
    }
}
