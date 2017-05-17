package com.polytech.turtle.view.events;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Gaetan on 15/05/2017.
 * MouseAdapter for clicks on turtleView
 */
public class ObstacleDrawer extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            System.out.println("New Obstacle");
            // TODO : Add obstacle here
        }
    }
}
