package com.polytech.turtle.view;

import com.polytech.turtle.view.components.JIntegerField;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Gaetan on 27/05/2017.
 * Manual Window
 */
public class ManualGUI extends MainGUI {

    public static final Dimension VGAP = new Dimension(1, 5);
    private static final Dimension HGAP = new Dimension(5, 1);

    private JButton buttonSquare;
    private JButton buttonPolygon;
    private JButton buttonSpiral;

    public JButton getButtonSquare() {
        return buttonSquare;
    }
    public JButton getButtonPolygon() {
        return buttonPolygon;
    }
    public JButton getButtonSpiral() {
        return buttonSpiral;
    }

    private JIntegerField textFieldStep;
    private JButton buttonMove;
    private JButton buttonRight;
    private JButton buttonLeft;
    private JButton buttonUp;
    private JButton buttonDown;

    private JMenuItem menuItemMove;
    private JMenuItem menuItemRight;
    private JMenuItem menuItemLeft;
    private JMenuItem menuItemUp;
    private JMenuItem menuItemDown;

    public JButton getButtonMove() {
        return buttonMove;
    }

    public JButton getButtonRight() {
        return buttonRight;
    }

    public JButton getButtonLeft() {
        return buttonLeft;
    }

    public JButton getButtonUp() {
        return buttonUp;
    }

    public JButton getButtonDown() {
        return buttonDown;
    }
    public JMenuItem getMenuItemMove() {
        return menuItemMove;
    }

    public JMenuItem getMenuItemRight() {
        return menuItemRight;
    }

    public JMenuItem getMenuItemLeft() {
        return menuItemLeft;
    }

    public JMenuItem getMenuItemUp() {
        return menuItemUp;
    }

    public JMenuItem getMenuItemDown() {
        return menuItemDown;
    }
    public JTextField getTextFieldStep() {
        return textFieldStep;
    }
    public int getStepValue() {
        return textFieldStep.getInt();
    }

    @Override
    protected void logoInit() {
        super.logoInit();

        toolBar.add(Box.createRigidArea(HGAP));
        toolBar.add(textFieldStep = new JIntegerField());

        toolBar.add(initButton(buttonMove = new JButton("Avancer"),  "Avancer 50"));
        toolBar.add(initButton(buttonRight = new JButton("Droite"),  "Droite 45"));
        toolBar.add(initButton(buttonLeft = new JButton("Gauche"), "Gauche 45"));
        toolBar.add(initButton(buttonUp = new JButton("Lever"),  "Lever Crayon"));
        toolBar.add(initButton(buttonDown = new JButton("Baisser"), "Baisser Crayon"));


        // First row of button at the bottom
        JPanel bottomButtonPanel = new JPanel(new GridLayout(0,3));

        buttonSquare = new JButton("Carré");
        buttonPolygon = new JButton("Polygone");
        buttonSpiral = new JButton("Spiral");

        // Second row of button at the bottom
        bottomButtonPanel.add(buttonSquare);
        bottomButtonPanel.add(buttonPolygon);
        bottomButtonPanel.add(buttonSpiral);

        menuCommandes.add(menuItemMove = new JMenuItem("Avancer"));
        menuCommandes.add(menuItemRight = new JMenuItem("Droite"));
        menuCommandes.add(menuItemLeft = new JMenuItem("Gauche"));
        menuCommandes.add(menuItemUp = new JMenuItem("Lever Crayon"));
        menuCommandes.add(menuItemDown = new JMenuItem("Baisser Crayon"));

        getContentPane().add(bottomButtonPanel, "South");
    }
}
