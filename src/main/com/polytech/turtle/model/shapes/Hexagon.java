package com.polytech.turtle.model.shapes;

import com.polytech.turtle.model.Turtle;

/**
 * Created by p1509413 on 10/05/2017.
 * Hexagon Shape
 */
public class Hexagon extends Polygon {

    /**
     * Default constructor
     *
     * @param turtle the drawer
     */
    public Hexagon(Turtle turtle) {
        super(turtle, 6);
    }

    /**
     * Constructor with side
     *
     * @param side_size Side size
     * @param turtle the drawer
     */
    public Hexagon(Turtle turtle, int side_size) {
        super(turtle, side_size, 6);
    }

}
