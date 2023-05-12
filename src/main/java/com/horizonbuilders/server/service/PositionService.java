package com.horizonbuilders.server.service;

import com.horizonbuilders.server.model.Position;
import java.io.IOException;
import java.util.List;

public interface PositionService {
    List<Position> getAllPositions();

    Position addPosition(String name,double salary) throws IOException;

    void updatePosition(String name,double salary,int id);

    void deletePositionById(int id) throws IOException;
    //
    Position findPositionById(int id);
}
