package com.aston_hibernate.dao;

import com.aston_hibernate.entity.Position;

import java.util.List;

public interface PositionDao {

    void addPosition(Position position);

    void updatePosition(Position position);

    void deletePosition(int id);

    Position getPositionById(int id);

    List<Position> listPosition();
}
