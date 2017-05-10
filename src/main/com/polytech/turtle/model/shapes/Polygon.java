package main.com.polytech.turtle.model.shapes;

import main.com.polytech.turtle.model.Turtle;

/**
 * Created by p1509413 on 10/05/2017.
 * Polygon
 */
public class Polygon extends AbstractShape {

    protected final int DEFAULT_SIDE_SIZE = 60;

    public Polygon(Turtle turtle, int nbSide) {
        super(turtle);
        polygon(DEFAULT_SIDE_SIZE, nbSide);
    }

    /**
     * Constructor
     *
     * @param turtle the drawer
     */
    public Polygon(Turtle turtle, int sideSize, int nbSide) {
        super(turtle);
        polygon(sideSize, nbSide);
    }

    protected void polygon(int sideSize, int nbSide) {
        for (int j = 0; j < nbSide; j++) {
            turtle.avancer(sideSize);
            turtle.droite(360 / nbSide);
        }
    }
}
