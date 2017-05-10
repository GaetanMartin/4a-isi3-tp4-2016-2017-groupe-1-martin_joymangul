package main.com.polytech.turtle.controller;

import main.com.polytech.turtle.model.Turtle;
import main.com.polytech.turtle.view.MainGUI;
import main.com.polytech.turtle.view.Sheet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

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

        turtleView.getColorList().addActionListener(e -> setColor(e));

        turtleView.getMenuItemAbout().addActionListener(e -> about());
        turtleView.getMenuItemHelp().addActionListener(e -> help());

        turtleView.getButtonSquare().addActionListener(e -> square());
        turtleView.getButtonPolygon().addActionListener(e -> polygon());
        turtleView.getButtonSpiral().addActionListener(e -> spiral());
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

    private void setColor(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        int n = cb.getSelectedIndex();
        turtleModel.setColor(n);
    }

    private void up() {
        turtleModel.leverCrayon();
    }

    private void down()  {
        turtleModel.baisserCrayon();
    }

    private void square() {
        this.turtleModel.carre();
    }

    private void polygon() {
        this.turtleModel.poly(60, 8);
    }

    private void spiral() {
        this.turtleModel.spiral(50, 40, 6);
    }

    public void reset() {
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
