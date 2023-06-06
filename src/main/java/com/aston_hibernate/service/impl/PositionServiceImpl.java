package com.aston_hibernate.service.impl;

import com.aston_hibernate.dao.PositionDao;
import com.aston_hibernate.entity.Position;
import com.aston_hibernate.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionDao positionDao;

    @Override
    @Transactional
    public void addPosition(Position position) {
        positionDao.addPosition(position);
    }

    @Override
    @Transactional
    public void updatePosition(Position position) {
        positionDao.updatePosition(position);
    }

    @Override
    @Transactional
    public void deletePosition(int id) {
        positionDao.deletePosition(id);
    }

    @Override
    @Transactional
    public Position getPositionById(int id) {
        return positionDao.getPositionById(id);
    }

    @Override
    @Transactional
    public List<Position> listPositions() {
        return positionDao.listPosition();
    }
}
