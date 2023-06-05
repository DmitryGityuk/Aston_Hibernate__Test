package com.aston_hibernate.service;

import com.aston_hibernate.entity.Position;

import java.util.List;

public interface PositionService {

    void addPosition(Position position);

    void updatePosition(Position position);

    void deletePosition(int id);

    Position getPositionById(int id);

    List<Position> listPositions();
}
