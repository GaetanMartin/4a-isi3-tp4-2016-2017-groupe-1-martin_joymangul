package com.polytech.turtle;

import com.polytech.turtle.controller.HomeController;
import com.polytech.turtle.view.Home;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 5/8/2017.
 */
public class App {
    public static void main(String[] args) {

        // Display Home Menu Window
        javax.swing.SwingUtilities.invokeLater(App::createAndShowHome);
    }

    private static void createAndShowHome() {
        Home view = new Home("Home - Turtle Project");
        new HomeController(view);
    }
}
