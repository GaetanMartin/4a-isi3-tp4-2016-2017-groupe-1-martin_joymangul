package main.com.polytech.turtle.view;

import main.com.polytech.turtle.model.Turtle;

import java.awt.*;

/**
 * Created by p1509413 on 26/04/2017.
 * View corresponding to a Turtle
 */
public class TurtleView {

    private final Turtle turtle;

    public TurtleView(Turtle turtle) {
        this.turtle = turtle;
    }

    public Polygon getShape() {

        Polygon arrow = new Polygon();

        //Angle de la turnRight
        double theta= Math.toRadians(-turtle.getDir());

        float rb = turtle.ARROW_BASE_WIDTH, rp = turtle.ARROW_HEIGHT;

        //Demi angle au sommet du triangle
        double alpha=Math.atan(rb / rp);
        //Rayon de la fleche
        double r=Math.sqrt( rp*rp + rb*rb );

        //Pointe
        Point p2=new Point((int) Math.round(turtle.getX() +r*Math.cos(theta)),
                (int) Math.round(turtle.getY() -r*Math.sin(theta)));
        arrow.addPoint(p2.x,p2.y);
        arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta + alpha) ),
                (int) Math.round( p2.y+r*Math.sin(theta + alpha) ));

        //Base2
        arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta - alpha) ),
                (int) Math.round( p2.y+r*Math.sin(theta - alpha) ));


        return arrow;
    }

}
