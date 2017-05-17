package com.polytech.turtle.model.shapes;

import com.polytech.turtle.model.TurtleInterface;

/**
 * Created by p1509413 on 10/05/2017.
 * Shape
 */
abstract class AbstractShape {

    protected final TurtleInterface turtle;

    /**
     * Default constructor
     * @param turtle the drawer
     */
    AbstractShape(TurtleInterface turtle) {
        this.turtle = turtle;
    }

}
