package main.com.polytech.turtle.model.shapes;

import main.com.polytech.turtle.model.Turtle;

/**
 * Created by p1509413 on 10/05/2017.
 * Spiral Shape
 */
public class Spiral extends AbstractShape {

    /**
     * Constructor
     *
     * @param turtle the drawer
     */
    public Spiral(Turtle turtle, int n, int k, int a) {
        super(turtle);
        for (int i = 0; i < k; i++) {
            turtle.couleurSuivante();
            turtle.avancer(n);
            turtle.droite(360 / a);
            n = n + 1;
        }
    }
}
