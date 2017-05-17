package com.polytech.turtle.view;

import com.polytech.turtle.model.ITurtle;

import java.awt.*;

/**
 * Created by p1509413 on 26/04/2017.
 * View corresponding to a Turtle
 */
public class TurtleView {

    private final ITurtle turtle;

    TurtleView(ITurtle turtle) {
        this.turtle = turtle;
    }

    public Polygon getShape() {

        Polygon arrow = new Polygon();

        //Angle de la turnRight
        double theta= Math.toRadians(-turtle.getDirection());

        float rb = ITurtle.ARROW_BASE_WIDTH, rp = ITurtle.ARROW_HEIGHT;

        //Demi angle au sommet du triangle
        double alpha=Math.atan(rb / rp);
        //Rayon de la fleche
        double r=Math.sqrt( rp*rp + rb*rb );

        //Pointe
        Point p2=new Point((int) Math.round(turtle.getPosition().getX() +r*Math.cos(theta)),
                (int) Math.round(turtle.getPosition().getY() -r*Math.sin(theta)));
        arrow.addPoint(p2.x,p2.y);
        arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta + alpha) ),
                (int) Math.round( p2.y+r*Math.sin(theta + alpha) ));

        //Base2
        arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta - alpha) ),
                (int) Math.round( p2.y+r*Math.sin(theta - alpha) ));


        return arrow;
    }

}
