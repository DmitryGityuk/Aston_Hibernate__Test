package com.aston_hibernate.dao.impl;

import com.aston_hibernate.dao.PositionDao;
import com.aston_hibernate.entity.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PositionDaoImpl implements PositionDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addPosition(Position position) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(position);
    }

    @Override
    public void updatePosition(Position position) {
        Session session = sessionFactory.getCurrentSession();
        session.update(position);
    }

    @Override
    public void deletePosition(int id) {
        Session session = sessionFactory.getCurrentSession();
        Position position = session.load(Position.class, new Integer(id));
        if (position != null) {
            session.delete(position);
        }
    }

    @Override
    public Position getPositionById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Position position = session.load(Position.class, new Integer(id));
        return position;
    }

    @Override
    public List<Position> listPosition() {
        Session session = sessionFactory.getCurrentSession();
        List<Position> positions = session.createQuery("from Position").list();
        return positions;
    }
}
