package com.polytech.turtle.view.shapes;


import java.awt.*;
import java.util.ArrayList;

/**
 * Created by p1509413 on 17/05/2017.
 * Triangle Shape
 */
class TriangleView extends PolygonalView {

    @Override
    public Polygon getShape(ArrayList<Point> points) {

        if (points.size() != 3) {
            throw new IllegalArgumentException("Must input 3 points");
        }

        return super.getShape(points);
    }
}
