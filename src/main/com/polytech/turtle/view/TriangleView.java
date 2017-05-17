package com.polytech.turtle.view;

import com.polytech.turtle.model.TurtleInterface;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by p1509413 on 17/05/2017.
 * Triangle Shape
 */
public class TriangleView extends ShapeView {

    @Override
    public Polygon getShape(ArrayList<Point> points) {

        if (points.size() != 3) {
            throw new IllegalArgumentException("Must input 3 points");
        }

        Point p1 = points.get(0);
        Point p2 = points.get(1);
        Point p3 = points.get(2);

        Polygon triangle = new Polygon();

        triangle.addPoint(p1.x, p1.y);
        triangle.addPoint(p2.x, p2.y);
        triangle.addPoint(p3.x, p3.y);

        return triangle;
    }
}
