package com.polytech.turtle.model.shapes;

import com.polytech.turtle.model.Turtle;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by p1509413 on 10/05/2017.
 * Shape
 */
public abstract class AbstractShape {

    protected final Turtle turtle;

    /**
     * Default constructor
     * @param turtle the drawer
     */
    AbstractShape(Turtle turtle) {
        this.turtle = turtle;
    }

}
