package com.polytech.turtle.model.shapes;

import com.polytech.turtle.model.TurtleInterface;

/**
 * Created by p1509413 on 10/05/2017.
 * Square Shape
 */
public class Square extends Polygon {

    /**
     * Constructor with side size
     *
     * @param turtle the drawer
     * @param side_size side size
     */
    public Square(TurtleInterface turtle, int side_size) {
        super(turtle, side_size, 4);
    }

}
