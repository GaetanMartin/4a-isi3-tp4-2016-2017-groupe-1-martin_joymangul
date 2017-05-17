package com.polytech.turtle.controller;

import com.polytech.turtle.model.Turtle;
import com.polytech.turtle.view.Home;
import com.polytech.turtle.view.MainGUI;

/**
 * Created by p1509413 on 17/05/2017.
 * Controller for view window
 */
public class HomeController {

    public HomeController(Home home) {
        home.getManualModeBtn().addActionListener(e -> javax.swing.SwingUtilities.invokeLater(HomeController::manualMode));
        home.getAutomaticModeBtn().addActionListener(e -> javax.swing.SwingUtilities.invokeLater(HomeController::automaticMode));
        home.getFlockingModeBtn().addActionListener(e -> javax.swing.SwingUtilities.invokeLater(HomeController::flockingMode));
    }

    private static void flockingMode() {
        System.out.println("flocking");
        Turtle model = new Turtle();
        MainGUI view = new MainGUI(); // Todo Put Flocking View
        TurtleController c = new TurtleController(model, view);
        c.initController();
    }

    private static void automaticMode() {
        System.out.println("flocking");
        Turtle model = new Turtle();
        MainGUI view = new MainGUI(); // Todo Put Automatic View
        TurtleController c = new TurtleController(model, view);
        c.initController();
    }

    private static void manualMode() {
        System.out.println("manual");
        Turtle model = new Turtle();
        MainGUI view = new MainGUI();
        TurtleController c = new TurtleController(model, view);
        c.initController();
    }


}
