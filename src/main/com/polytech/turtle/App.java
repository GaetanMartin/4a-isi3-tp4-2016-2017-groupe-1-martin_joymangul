package main.com.polytech.turtle;

import main.com.polytech.turtle.controller.TurtleController;
import main.com.polytech.turtle.model.Turtle;
import main.com.polytech.turtle.view.MainGUI;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 5/8/2017.
 */
public class App {
    public static void main(String[] args) {
        // Assemble all the pieces of the MVC
        Turtle model = new Turtle();
        MainGUI view = new MainGUI();
        TurtleController c = new TurtleController(model, view);
        c.initController();
    }
}