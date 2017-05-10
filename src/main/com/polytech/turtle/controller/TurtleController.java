package com.polytech.turtle.controller;

import com.polytech.turtle.Utils.Colors;
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
    private Turtle currentTurtle;
    private MainGUI turtleView;
    private Sheet sheet;

    public TurtleController(Turtle turtle, MainGUI turtleView) {
        this.currentTurtle = turtle;
        this.sheet = new Sheet();
        this.turtleView = turtleView;
        this.sheet.addTortue(turtle);
    }

    public void initController() {
        turtleView.setSheet(sheet);
        turtleView.getTextFieldStep().setText("45");
        turtleView.getTextFieldStep().setColumns(5);
        turtleView.getButtonMove().addActionListener(e -> this.move(turtleView.getStepValue()));
        turtleView.getButtonRight().addActionListener(e -> this.right(turtleView.getStepValue()));
        turtleView.getButtonLeft().addActionListener(e -> this.left(turtleView.getStepValue()));
        turtleView.getButtonDown().addActionListener(e -> this.down());
        turtleView.getButtonUp().addActionListener(e -> this.up());
        turtleView.getButtonReset().addActionListener(e -> this.reset());
        turtleView.getButtonAddTurtle().addActionListener(e -> this.addTurtle());

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

        Colors.getAllColorsName().forEach((String colorName) -> turtleView.getColorList().addItem(colorName));
        turtleView.getColorList().addActionListener(this::setColor);

        turtleView.getMenuItemAbout().addActionListener(e -> about());
        turtleView.getMenuItemHelp().addActionListener(e -> help());

        turtleView.getButtonSquare().addActionListener(e -> square());
        turtleView.getButtonPolygon().addActionListener(e -> polygon());
        turtleView.getButtonSpiral().addActionListener(e -> spiral());
    }

    protected void move(int v)
    {
        System.out.println("command moveForward");
        currentTurtle.moveForward(v);
    }

    protected void right(int v)
    {
        currentTurtle.turnRight(v);
        //sheet.repaint();
    }

    public void addTurtle() {
        System.out.println("Nouvelle Tortue");
        Turtle t = new Turtle();
        this.currentTurtle = t;
        this.sheet.addTortue(t);
    }

    protected void left(int v)
    {
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

    private void down()  {
        currentTurtle.lowerPen();
    }

    private void square() {
        new Square(this.currentTurtle, 100);
    }

    private void polygon() {
        new Hexagon(this.currentTurtle,60);
    }

    private void spiral() {
        new Spiral(this.currentTurtle, 50, 40, 6);
    }

    private void reset() {
        sheet.reset();
        // Replace la fr.polytech.turtle au centre
        Dimension size = sheet.getSize();
        currentTurtle.setPosition(size.width/2, size.height/2);
    }

    private void help() {
        JOptionPane.showMessageDialog(null, "C'est une aide " , "Aide", JOptionPane.INFORMATION_MESSAGE);
    }

    private void about() {
        JOptionPane.showMessageDialog(null, "À propos", "À propos", JOptionPane.INFORMATION_MESSAGE);
    }

    private void quit() {
        System.exit(0);
    }

    private void initMenuItemKeyEvent(JMenuItem menuItem, int key)
    {
        menuItem.setAccelerator(KeyStroke.getKeyStroke(key, 0, false));
    }

}
