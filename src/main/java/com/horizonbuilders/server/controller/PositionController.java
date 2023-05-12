package com.horizonbuilders.server.controller;

import com.horizonbuilders.server.model.Position;
import com.horizonbuilders.server.service.PositionService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/position")
@RequiredArgsConstructor
public class PositionController {
    @Autowired
    private final PositionService positionService;

    @PostMapping
//    @PreAuthorize("hasRole('ADMIN')")
    public Position addPosition(
            @NotNull @NotBlank @RequestParam("name") String name,
            @RequestParam("salary") double salary) throws IOException {
        return positionService.addPosition(name, salary);
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
