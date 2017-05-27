package com.polytech.turtle.controller;

import com.polytech.turtle.Utils.Colors;
import com.polytech.turtle.controller.events.ObstacleMouseAdapter;
import com.polytech.turtle.environment.AbstractEnvironment;
import com.polytech.turtle.environment.AutomaticIEnvironment;
import com.polytech.turtle.environment.ControlledEnvironment;
import com.polytech.turtle.environment.FlockingIEnvironment;
import com.polytech.turtle.model.ITurtle;
import com.polytech.turtle.model.Point;
import com.polytech.turtle.model.Turtle;
import com.polytech.turtle.model.shapes.Hexagon;
import com.polytech.turtle.model.shapes.Spiral;
import com.polytech.turtle.model.shapes.Square;
import com.polytech.turtle.view.MainGUI;
import com.polytech.turtle.view.Sheet;
import com.polytech.turtle.controller.events.TurtleSelector;
import com.polytech.turtle.view.shapes.TurtleView;

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

    static ITurtle currentTurtle;
    private MainGUI turtleView;
    private Sheet sheet;
    private AbstractEnvironment environment;

    TurtleController(ITurtle turtle, MainGUI turtleView) {
        currentTurtle = turtle;
        this.sheet = new Sheet();
        this.turtleView = turtleView;
        this.addTurtle(turtle);
    }

    public static void setCurrentTurtle(ITurtle currentTurtle) {
        TurtleController.currentTurtle = currentTurtle;
    }

    void initController() {
        turtleView.setSheet(sheet);
        this.sheet.addMouseListener(new ObstacleMouseAdapter(this.sheet));
        initTopButton();
        initMenuItem();
        initColorList();
    }

    protected void initTopButton() {
        turtleView.getButtonReset().addActionListener(e -> this.reset());
        turtleView.getButtonAddTurtle().addActionListener(e -> this.addTurtle());
    }


    protected void initMenuItem() {

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
        Turtle t = new Turtle();
        this.addTurtle(t);
    }

    private void addTurtle(ITurtle turtle) {
        System.out.println("Nouvelle Tortue");
        currentTurtle = turtle;
        TurtleView turtleView = this.sheet.addTurtle(turtle);
        this.sheet.addMouseListener(new TurtleSelector(turtle, turtleView));

    }

    void left(int v) {
        currentTurtle.turnLeft(v);
    }

    private void setColor(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        Color color = Colors.getColor((String) cb.getSelectedItem());
        currentTurtle.setColor(color);
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

    void controlledEnvironment() {
        if(environment != null)
        {
            environment.stop();
        }
        environment =  new ControlledEnvironment(sheet.getTurtles(), sheet.getObstacles());
        this.sheet.reset();
    }

    void automaticEnvironment() {
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
        environment = new AutomaticIEnvironment(sheet.getTurtles(), sheet.getObstacles(), SPEED);
        environment.start();
    }

    void flockingEnvironment() {
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
