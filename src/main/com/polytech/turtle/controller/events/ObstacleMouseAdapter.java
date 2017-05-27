package com.polytech.turtle.controller.events;

import com.polytech.turtle.model.Obstacle;
import com.polytech.turtle.model.Point;
import com.polytech.turtle.view.Sheet;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 5/18/2017.
 */
public class ObstacleMouseAdapter extends MouseAdapter {
    private Sheet sheet;

    public ObstacleMouseAdapter(Sheet sheet) {
        this.sheet = sheet;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            System.out.println("New Obstacle");
            Obstacle obstacle = new Obstacle(new Point(e.getX(), e.getY()));
            this.sheet.addObstacle(obstacle);
            obstacle.notifyView();
        }
    }
}
