package com.polytech.turtle.view.events;

import com.polytech.turtle.model.Obstacle;
import com.polytech.turtle.model.Point;
import com.polytech.turtle.view.Sheet;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Gaetan on 15/05/2017.
 * MouseAdapter for clicks on turtleView
 */
public class ObstacleDrawer extends MouseAdapter {
    private Sheet sheet;

    public ObstacleDrawer(Sheet sheet) {
        this.sheet = sheet;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            System.out.println("New Obstacle");
            Obstacle obstacle = new Obstacle(new Point(e.getX(), e.getY()));
            this.sheet.addObstacle(obstacle);
            obstacle.notifyView();
        }
    }
}
