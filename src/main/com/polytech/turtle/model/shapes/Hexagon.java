package com.polytech.turtle.model.shapes;

import com.polytech.turtle.model.Turtle;
import com.polytech.turtle.model.TurtleInterface;

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
     * @param turtle the drawer
     * @param side_size Side size
     */
    public Hexagon(TurtleInterface turtle, int side_size) {
        super(turtle, side_size, 6);
    }

}
