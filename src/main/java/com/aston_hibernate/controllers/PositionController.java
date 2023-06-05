package com.aston_hibernate.controllers;

import com.aston_hibernate.entity.Position;
import com.aston_hibernate.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @GetMapping("/positions")
    public List<Position> showAllPosition() {
        List<Position> allPosition = positionService.listPositions();
        return allPosition;
    }

    @GetMapping("/positions/{id}")
    public Position getPosition(@PathVariable int id) {
        Position position = positionService.getPositionById(id);
        return position;
    }

    @PostMapping("/positions")
    public Position addNewPosition(@RequestBody Position position) {
        positionService.addPosition(position);
        return position;
    }

    @PutMapping("/positions")
    public Position updatePosition(@RequestBody Position position) {
        positionService.updatePosition(position);
        return position;
    }

    @DeleteMapping("/positions/{id}")
    public String deletePosition(@PathVariable int id) {
        positionService.deletePosition(id);
        return "Position with ID = " + id + " was successfuly deleted";
    }
}
