package main.com.polytech.turtle.controller;

import main.com.polytech.turtle.Utils.Colors;
import main.com.polytech.turtle.model.Turtle;
import main.com.polytech.turtle.model.shapes.Hexagon;
import main.com.polytech.turtle.model.shapes.Spiral;
import main.com.polytech.turtle.model.shapes.Square;
import main.com.polytech.turtle.view.MainGUI;
import main.com.polytech.turtle.view.Sheet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * Created by p1509413 on 26/04/2017.
 * Controller for a turtle
 */
public class TurtleController {
    private Turtle turtleModel;
    private MainGUI turtleView;
    private Sheet turtlePanel;

    public TurtleController(Turtle turtleModel, MainGUI turtleView) {
        this.turtleModel = turtleModel;
        this.turtlePanel = new Sheet();
        this.turtleView = turtleView;
        this.turtleModel.setPosition(600 / 2, 400 / 2);
        this.turtlePanel.addTortue(turtleModel);
    }

    public void initController() {
        turtleView.setSheet(turtlePanel);
        turtleView.getTextFieldStep().setText("45");
        turtleView.getTextFieldStep().setColumns(5);
        turtleView.getButtonMove().addActionListener(e -> this.move(turtleView.getStepValue()));
        turtleView.getButtonRight().addActionListener(e -> this.right(turtleView.getStepValue()));
        turtleView.getButtonLeft().addActionListener(e -> this.left(turtleView.getStepValue()));
        turtleView.getButtonDown().addActionListener(e -> this.down());
        turtleView.getButtonUp().addActionListener(e -> this.up());
        turtleView.getButtonReset().addActionListener(e -> this.reset());

        turtleView.getMenuItemMove().addActionListener(e -> this.move(turtleView.getStepValue()));
        turtleView.getMenuItemRight().addActionListener(e -> this.right(turtleView.getStepValue()));
        turtleView.getMenuItemLeft().addActionListener(e -> this.left(turtleView.getStepValue()));
        turtleView.getMenuItemDown().addActionListener(e -> this.down());
        turtleView.getMenuItemUp().addActionListener(e -> this.up());

        this.initMenuItemKeyEvent(turtleView.getMenuItemReset(), KeyEvent.VK_N);
        this.initMenuItemKeyEvent(turtleView.getMenuItemQuit(), KeyEvent.VK_Q);
        turtleView.getMenuItemReset().addActionListener(e -> reset());
        turtleView.getMenuItemQuit().addActionListener(e -> quit());

        Colors.NOIRE.getAllColorsName().forEach((String colorName) -> turtleView.getColorList().addItem(colorName));
        turtleView.getColorList().addActionListener(this::setColor);

        turtleView.getMenuItemAbout().addActionListener(e -> about());
        turtleView.getMenuItemHelp().addActionListener(e -> help());

        turtleView.getButtonSquare().addActionListener(e -> square());
        turtleView.getButtonPolygon().addActionListener(e -> polygon());
        turtleView.getButtonSpiral().addActionListener(e -> spiral());
    }

    protected void move(int length)
    {
        System.out.println("command moveForward");
        turtleModel.moveForward(length);
    }

    protected void right(int degree)
    {
        turtleModel.turnRight(degree);
        //turtlePanel.repaint();
    }

    protected void left(int degree)
    {
        turtleModel.turnLeft(degree);
    }

    private void setColor(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        Color color = Colors.NOIRE.getColor((String) cb.getSelectedItem());
        turtleModel.setColor(color);
    }

    private void up() {
        turtleModel.liftPen();
    }

    private void down()  {
        turtleModel.lowerPen();
    }

    private void square() {
        new Square(this.turtleModel, 100);
    }

    private void polygon() {
        new Hexagon(this.turtleModel,60);
    }

    private void spiral() {
        new Spiral(this.turtleModel, 50, 40, 6);
    }

    private void reset() {
        turtlePanel.reset();
        // Replace la fr.polytech.turtle au centre
        Dimension size = turtlePanel.getSize();
        turtleModel.setPosition(size.width/2, size.height/2);
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
