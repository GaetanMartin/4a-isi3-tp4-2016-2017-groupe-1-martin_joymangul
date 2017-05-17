package com.polytech.turtle.view;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by p1509413 on 17/05/2017.
 * View of a shape (turtle, obstacle, ...)
 */
public abstract class ShapeView {

    public Polygon getShape(ArrayList<Point> points) { throw new NotImplementedException();}

}
