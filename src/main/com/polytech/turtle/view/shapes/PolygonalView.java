package com.polytech.turtle.view.shapes;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by p1509413 on 17/05/2017.
 * View of a shape (turtle, obstacle, ...)
 */
abstract class PolygonalView {

    public Polygon getShape(ArrayList<Point> points) {
        Polygon polygon = new Polygon();
        points.forEach(point -> polygon.addPoint(point.x, point.y));
        return polygon;
    }

}
