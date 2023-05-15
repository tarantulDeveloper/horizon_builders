package com.horizonbuilders.server.service;

import com.horizonbuilders.server.model.Position;

import java.io.IOException;
import java.util.List;

public interface PositionService {
    List<Position> getAllPositions();

    Position addPosition(String name, double salary);

    void updatePosition(String name, double salary, int positionId);

    void deletePositionById(int positionId);

    //
    Position findPositionById(int positionId);
}
