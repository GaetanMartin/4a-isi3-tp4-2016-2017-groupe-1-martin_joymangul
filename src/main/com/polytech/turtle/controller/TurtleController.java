package com.polytech.turtle.controller;

import com.polytech.turtle.Utils.Colors;
import com.polytech.turtle.environment.AutomaticIEnvironment;
import com.polytech.turtle.environment.FlockingIEnvironment;
import com.polytech.turtle.environment.IEnvironment;
import com.polytech.turtle.model.ITurtle;
import com.polytech.turtle.model.Point;
import com.polytech.turtle.model.Turtle;
import com.polytech.turtle.model.shapes.Hexagon;
import com.polytech.turtle.model.shapes.Spiral;
import com.polytech.turtle.model.shapes.Square;
import com.polytech.turtle.view.MainGUI;
import com.polytech.turtle.view.Sheet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * Created by p1509413 on 26/04/2017.
 * Controller for a turtle
 */
public class TurtleController {
    private final int SPEED = 100; // in milliseconds

    private static ITurtle currentTurtle;
    private MainGUI turtleView;
    private Sheet sheet;
    private IEnvironment environment;

    public TurtleController(ITurtle turtle, MainGUI turtleView) {
        currentTurtle = turtle;
        this.sheet = new Sheet();
        this.turtleView = turtleView;
        this.sheet.addTurtle(turtle);
    }

    public static void setCurrentTurtle(ITurtle currentTurtle) {
        TurtleController.currentTurtle = currentTurtle;
    }

    void initController() {
        turtleView.setSheet(sheet);
        this.sheet.addMouseListener(new ObstacleMouseAdapter(this.sheet));
        this.initTextField();
        this.initTopButton();
        this.initBottomButton();
        this.initMenuItem();
        this.initColorList();
    }

    private void initTextField()
    {
        turtleView.getTextFieldStep().setText("45");
        turtleView.getTextFieldStep().setColumns(5);
    }

    private void initTopButton() {
        turtleView.getButtonMove().addActionListener(e -> this.move(turtleView.getStepValue()));
        turtleView.getButtonRight().addActionListener(e -> this.right(turtleView.getStepValue()));
        turtleView.getButtonLeft().addActionListener(e -> this.left(turtleView.getStepValue()));
        turtleView.getButtonDown().addActionListener(e -> this.down());
        turtleView.getButtonUp().addActionListener(e -> this.up());
        turtleView.getButtonReset().addActionListener(e -> this.reset());
        turtleView.getButtonAddTurtle().addActionListener(e -> this.addTurtle());
        turtleView.getButtonAutomatic().addActionListener(e -> this.automaticEnvironment());
        turtleView.getButtonFlocking().addActionListener(e -> this.flockingEnvironment());
    }

    private void initBottomButton() {
        turtleView.getButtonSquare().addActionListener(e -> square());
        turtleView.getButtonPolygon().addActionListener(e -> polygon());
        turtleView.getButtonSpiral().addActionListener(e -> spiral());
    }

    private void initMenuItem() {
        turtleView.getMenuItemMove().addActionListener(e -> this.move(turtleView.getStepValue()));
        turtleView.getMenuItemRight().addActionListener(e -> this.right(turtleView.getStepValue()));
        turtleView.getMenuItemLeft().addActionListener(e -> this.left(turtleView.getStepValue()));
        turtleView.getMenuItemDown().addActionListener(e -> this.down());
        turtleView.getMenuItemUp().addActionListener(e -> this.up());
        turtleView.getMenuItemAddTurtle().addActionListener(e -> this.addTurtle());

        this.initMenuItemKeyEvent(turtleView.getMenuItemReset(), KeyEvent.VK_N);
        this.initMenuItemKeyEvent(turtleView.getMenuItemQuit(), KeyEvent.VK_Q);
        turtleView.getMenuItemReset().addActionListener(e -> reset());
        turtleView.getMenuItemQuit().addActionListener(e -> quit());

        turtleView.getMenuItemAbout().addActionListener(e -> about());
        turtleView.getMenuItemHelp().addActionListener(e -> help());
    }

    private void initColorList() {
        Colors.getColorName().forEach((String colorName) -> turtleView.getColorList().addItem(colorName));
        turtleView.getColorList().addActionListener(this::setColor);
    }

    void move(int v) {
        System.out.println("command moveForward");
        currentTurtle.moveForward(v);
    }

    void right(int v) {
        currentTurtle.turnRight(v);
        //sheet.repaint();
    }

    private void addTurtle() {
        System.out.println("Nouvelle Tortue");
        Turtle t = new Turtle();
        currentTurtle = t;
        this.sheet.addTurtle(t);
    }

    void left(int v) {
        currentTurtle.turnLeft(v);
    }

    private void setColor(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        Color color = Colors.getColor((String) cb.getSelectedItem());
        currentTurtle.setColor(color);
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

    private void reset() {
        sheet.reset();
        // Replace la fr.polytech.turtle au centre
        Dimension size = sheet.getSize();
        currentTurtle.setPosition(new Point(size.width / 2, size.height / 2));
    }

    private void help() {
        JOptionPane.showMessageDialog(null, "C'est une aide ", "Aide", JOptionPane.INFORMATION_MESSAGE);
    }

    private void about() {
        JOptionPane.showMessageDialog(null, "À propos", "À propos", JOptionPane.INFORMATION_MESSAGE);
    }

    private void quit() {
        System.exit(0);
    }

    private void initMenuItemKeyEvent(JMenuItem menuItem, int key) {
        menuItem.setAccelerator(KeyStroke.getKeyStroke(key, 0, false));
    }

    private void automaticEnvironment() {
        if(environment != null)
        {
            environment.stop();
        }


        sheet.getTurtles().clear();
        for (int i = 0; i < Turtle.NUMBER_OF_TURTLE; i++) {
            Turtle turtle = new Turtle();
            turtle.randonmise();
            sheet.addTurtle(turtle);
        }
        environment = new AutomaticIEnvironment(sheet.getTurtles(), SPEED);
        environment.start();
    }

    private void flockingEnvironment() {
        if(environment != null)
        {
            environment.stop();
        }
        sheet.getTurtles().clear();
        for (int i = 0; i < Turtle.NUMBER_OF_TURTLE; i++) {
            Turtle turtle = new Turtle();
            turtle.randonmise();
            sheet.addTurtle(turtle);
        }

        environment = new FlockingIEnvironment(sheet.getTurtles(), sheet.getObstacles(), SPEED);
        environment.start();
    }
}
