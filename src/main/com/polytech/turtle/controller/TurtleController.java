package main.com.polytech.turtle.controller;

import main.com.polytech.turtle.model.Turtle;
import main.com.polytech.turtle.view.MainGUI;
import main.com.polytech.turtle.view.Sheet;

import java.awt.*;

/**
 * Created by p1509413 on 26/04/2017.
 */
public class TurtleController {
    private Turtle turtleModel;
    private MainGUI turtleView;
    private Sheet turtlePanel;

    public TurtleController(Turtle turtleModel, MainGUI turtleView) {
        this.turtleModel = turtleModel;
        this.turtlePanel = new Sheet();
        this.turtleView = turtleView;
        this.turtleModel.setPosition(500 / 2, 500 / 2);
        this.turtlePanel.addTortue(turtleModel);
    }

    public void initController() {
        turtleView.setSheet(turtlePanel);
        turtleView.getButtonMove().addActionListener(e -> this.move(turtleView.getInputValue()));
        turtleView.getButtonRight().addActionListener(e -> this.right(turtleView.getInputValue()));
        turtleView.getButtonLeft().addActionListener(e -> this.left(turtleView.getInputValue()));
        turtleView.getButtonDown().addActionListener(e -> this.down());
        turtleView.getButtonUp().addActionListener(e -> this.up());
        turtleView.getButtonReset().addActionListener(e -> this.reset());
    }

    public void move(String step)
    {
        System.out.println("command avancer");
        try {
            int v = Integer.parseInt(step);
            turtleModel.avancer(v);
        } catch (NumberFormatException ex){
            System.err.println("ce n'est pas un nombre : " + step);
        }
    }

    public void right(String step)
    {
        try {
            int v = Integer.parseInt(step);
            turtleModel.droite(v);
        } catch (NumberFormatException ex){
            System.err.println("ce n'est pas un nombre : " + step);
        }
        //turtlePanel.repaint();
    }

    public void left(String step)
    {
        try {
            int v = Integer.parseInt(step);
            turtleModel.gauche(v);
        } catch (NumberFormatException ex){
            System.err.println("ce n'est pas un nombre : " + step);
        }
    }

    private void up() {
        turtleModel.leverCrayon();
    }

    private void down()  {
        turtleModel.baisserCrayon();
    }

    public void reset() {
        turtlePanel.reset();
        // Replace la fr.polytech.turtle au centre
        Dimension size = turtlePanel.getSize();
        turtleModel.setPosition(size.width/2, size.height/2);
    }


    private void quit() {
        System.exit(0);
    }

}
