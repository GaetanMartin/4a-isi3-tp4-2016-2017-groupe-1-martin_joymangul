package com.polytech.turtle.controller;

import com.polytech.turtle.model.Turtle;
import com.polytech.turtle.view.Home;
import com.polytech.turtle.view.MainGUI;
import com.polytech.turtle.view.ManualGUI;

/**
 * Created by p1509413 on 17/05/2017.
 * Controller for view window
 */
public class HomeController {
    public TurtleController getTurtleController() {
        return turtleController;
    }

    public void setTurtleController(TurtleController turtleController) {
        this.turtleController = turtleController;
    }

    private TurtleController turtleController;

    public HomeController(Home home) {
        home.getManualModeBtn().addActionListener(e ->this.manualMode());
        home.getAutomaticModeBtn().addActionListener((e ->this.automaticMode()));
        home.getFlockingModeBtn().addActionListener((e ->this.flockingMode()));
        initTurtleController();
    }

    private void initTurtleController() {
        Turtle model = new Turtle();
        MainGUI view = new MainGUI();
        turtleController = new TurtleController(model, view);
        turtleController.initController();
    }

    protected void flockingMode() {
        System.out.println("Flocking");
        turtleController.flockingEnvironment();
    }

    protected void automaticMode() {
        System.out.println("Automatic");
        turtleController.automaticEnvironment();
    }

    protected void manualMode() {
        System.out.println("Manual");
        turtleController = new TurtleManualController(new Turtle(), new ManualGUI());
        turtleController.initController();
        turtleController.controlledEnvironment();
    }


}
