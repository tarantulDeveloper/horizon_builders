package com.horizonbuilders.server.service;

import com.horizonbuilders.server.model.Position;
import org.springframework.data.domain.Page;

public interface PositionService {
    Page<Position> getAllPositions(int pageNo, int pageSize, String sortBy);

    Position addPosition(String name, double salary);

    Position updatePosition(String name, double salary, int positionId);

    void deletePositionById(int positionId);

    Position getPositionById(int positionId);
}
