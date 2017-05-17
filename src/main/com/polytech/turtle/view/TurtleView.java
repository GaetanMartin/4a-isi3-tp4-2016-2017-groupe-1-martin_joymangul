package com.polytech.turtle.view;

import com.polytech.turtle.model.ITurtle;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by p1509413 on 26/04/2017.
 * View corresponding to a Turtle
 */
public class TurtleView extends TriangleView {

    private final ITurtle turtle;

    TurtleView(ITurtle turtle) {
        this.turtle = turtle;
    }

    public Polygon getShape() {
        ArrayList<Point> point = new ArrayList<>();

        //Angle de la turnRight
        double theta= Math.toRadians(-turtle.getDirection());

        float rb = ITurtle.ARROW_BASE_WIDTH, rp = ITurtle.ARROW_HEIGHT;

        //Demi angle au sommet du triangle
        double alpha=Math.atan(rb / rp);
        //Rayon de la fleche
        double r=Math.sqrt( rp*rp + rb*rb );

        Point point2=new Point((int) Math.round(turtle.getPosition().getX() +r*Math.cos(theta)), (int) Math.round(turtle.getPosition().getY() -r*Math.sin(theta)));
        Point point3 = new Point((int) Math.round( point2.x-r*Math.cos(theta + alpha) ),(int) Math.round( point2.y+r*Math.sin(theta + alpha)));
        Point point1 = new Point((int) Math.round( point2.x-r*Math.cos(theta - alpha) ), (int) Math.round( point2.y+r*Math.sin(theta - alpha)));

        point.add(point1);
        point.add(point2);
        point.add(point3);

        return super.getShape(point);
    }
}
