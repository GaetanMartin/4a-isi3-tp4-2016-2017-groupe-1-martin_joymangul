package com.polytech.turtle.model.shapes;

import com.polytech.turtle.model.ITurtle;

/**
 * Created by p1509413 on 10/05/2017.
 * Shape
 */
abstract class AbstractShape {

    protected final ITurtle turtle;

    /**
     * Default constructor
     * @param turtle the drawer
     */
    AbstractShape(ITurtle turtle) {
        this.turtle = turtle;
    }

}
