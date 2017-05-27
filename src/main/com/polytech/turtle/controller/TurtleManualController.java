package com.polytech.turtle.controller;

import com.polytech.turtle.model.ITurtle;
import com.polytech.turtle.model.shapes.Hexagon;
import com.polytech.turtle.model.shapes.Spiral;
import com.polytech.turtle.model.shapes.Square;
import com.polytech.turtle.view.MainGUI;
import com.polytech.turtle.view.ManualGUI;

/**
 * Created by Gaetan on 27/05/2017.
 * Controller for Manual mode
 */
public class TurtleManualController extends TurtleController {

    private ManualGUI turtleView;

    TurtleManualController(ITurtle turtle, ManualGUI turtleView) {
        super(turtle, turtleView);
        this.turtleView = turtleView;
    }

    @Override
    void initController() {
        super.initController();
        this.initBottomButton();
        this.initTextField();
    }


    private void initTextField() {
        turtleView.getTextFieldStep().setText("45");
        turtleView.getTextFieldStep().setColumns(5);
    }

    private void initBottomButton() {
        turtleView.getButtonSquare().addActionListener(e -> square());
        turtleView.getButtonPolygon().addActionListener(e -> polygon());
        turtleView.getButtonSpiral().addActionListener(e -> spiral());
    }

    @Override
    protected void initTopButton() {
        super.initTopButton();
        turtleView.getButtonUp().addActionListener(e -> this.up());
        turtleView.getButtonMove().addActionListener(e -> this.move(turtleView.getStepValue()));
        turtleView.getButtonRight().addActionListener(e -> this.right(turtleView.getStepValue()));
        turtleView.getButtonLeft().addActionListener(e -> this.left(turtleView.getStepValue()));
        turtleView.getButtonDown().addActionListener(e -> this.down());
    }

    @Override
    protected void initMenuItem() {
        super.initMenuItem();
        turtleView.getMenuItemMove().addActionListener(e -> this.move(turtleView.getStepValue()));
        turtleView.getMenuItemRight().addActionListener(e -> this.right(turtleView.getStepValue()));
        turtleView.getMenuItemLeft().addActionListener(e -> this.left(turtleView.getStepValue()));
        turtleView.getMenuItemDown().addActionListener(e -> this.down());
        turtleView.getMenuItemUp().addActionListener(e -> this.up());
    }

    private void up() {
        currentTurtle.liftPen();
    }

    private void down() {
        currentTurtle.lowerPen();
    }

    private void square() {
        new Square(currentTurtle, 100);
    }

    private void polygon() {
        new Hexagon(currentTurtle, 60);
    }

    private void spiral() {
        new Spiral(currentTurtle, 50, 40, 6);
    }
}
