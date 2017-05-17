package com.polytech.turtle.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * Created by p1509413 on 17/05/2017.
 * Home Window
 */
public class Home extends JFrame {

    public JButton getManualModeBtn() {
        return manualModeBtn;
    }

    public JButton getAutomaticModeBtn() {
        return automaticModeBtn;
    }

    public JButton getFlockingModeBtn() {
        return flockingModeBtn;
    }

    private JButton manualModeBtn;
    private JButton automaticModeBtn;
    private JButton flockingModeBtn;

    public Home(String name) {
        super(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(getContentPane());
        setVisible(true);
        pack();
    }

    private void addComponentsToPane(final Container pane) {

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        // Layout
        GridLayout experimentLayout = new GridLayout(0,3);
        final JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(experimentLayout);

        // Buttons Creation
        manualModeBtn = new JButton("Mode Manuel");
        automaticModeBtn = new JButton("Mode Automatique");
        flockingModeBtn = new JButton("Flocking");

        //Add buttons to panel
        buttonPanel.add(manualModeBtn);
        buttonPanel.add(automaticModeBtn);
        buttonPanel.add(flockingModeBtn);

        // Add components panel to main frame
        pane.add(buttonPanel, BorderLayout.NORTH);
    }
}
