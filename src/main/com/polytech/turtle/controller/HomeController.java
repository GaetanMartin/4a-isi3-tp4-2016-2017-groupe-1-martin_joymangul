package com.polytech.turtle.controller;

import com.polytech.turtle.model.Turtle;
import com.polytech.turtle.view.Home;
import com.polytech.turtle.view.MainGUI;

/**
 * Created by p1509413 on 17/05/2017.
 * Controller for view window
 */
public class HomeController {
    private TurtleController turtleController;

    public HomeController(Home home) {
        home.getManualModeBtn().addActionListener(e ->this.manualMode());
        home.getAutomaticModeBtn().addActionListener((e ->this.automaticMode()));
        home.getFlockingModeBtn().addActionListener((e ->this.flockingMode()));
    }

    private void initTurtleController() {
        System.out.println("flocking");
        Turtle model = new Turtle();
        MainGUI view = new MainGUI(); // Todo Put Flocking View
        turtleController = new TurtleController(model, view);
        turtleController.initController();
    }

    private void flockingMode() {
        initTurtleController();
        turtleController.flockingEnvironment();
    }

    private void automaticMode() {
        initTurtleController();
        turtleController.automaticEnvironment();
    }

    private void manualMode() {
        initTurtleController();
        turtleController.controlledEnvironment();
    }


}
