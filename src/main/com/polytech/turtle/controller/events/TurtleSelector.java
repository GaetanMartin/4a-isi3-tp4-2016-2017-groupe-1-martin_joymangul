package com.polytech.turtle.controller.events;

import com.polytech.turtle.controller.TurtleController;
import com.polytech.turtle.model.ITurtle;
import com.polytech.turtle.view.shapes.TurtleView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Gaetan on 15/05/2017.
 * MouseAdapter for clicks on turtleView
 */
public class TurtleSelector extends MouseAdapter {
    private ITurtle turtle;
    private TurtleView turtleView;

    public TurtleSelector(ITurtle turtle, TurtleView turtleView) {
        this.turtle = turtle;
        this.turtleView = turtleView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (turtleView.getShape().contains(e.getX(), e.getY())) {
            System.out.println("Turtle Selected");
            TurtleController.setCurrentTurtle(turtle);
        }
    }
}
