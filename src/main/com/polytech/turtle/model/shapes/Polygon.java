package com.polytech.turtle.model.shapes;

import com.polytech.turtle.model.ITurtle;
import com.polytech.turtle.model.Turtle;

/**
 * Created by p1509413 on 10/05/2017.
 * Polygon
 */
class Polygon extends AbstractShape {

    private final int DEFAULT_SIDE_SIZE = 60;

    Polygon(Turtle turtle, int nbSide) {
        super(turtle);
        polygon(DEFAULT_SIDE_SIZE, nbSide);
    }

    /**
     * Constructor
     *
     * @param turtle the drawer
     */
    Polygon(ITurtle turtle, int sideSize, int nbSide) {
        super(turtle);
        polygon(sideSize, nbSide);
    }

    private void polygon(int sideSize, int nbSide) {
        for (int j = 0; j < nbSide; j++) {
            turtle.moveForward(sideSize);
            turtle.turnRight(360 / nbSide);
        }
    }
}
