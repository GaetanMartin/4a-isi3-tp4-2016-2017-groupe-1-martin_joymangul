package fr.polytech.turtle.view;

import fr.polytech.turtle.model.Turtle;

import java.awt.*;

/**
 * Created by p1509413 on 26/04/2017.
 */
public class TurtleView {

    private final Turtle turtle;

    public TurtleView(Turtle turtle) {
        this.turtle = turtle;
    }

    /*
    //Calcule les 3 coins du triangle a partir de
		// la position de la fr.polytech.turtle p
		Point p = new Point(x,y);
		Polygon arrow = new Polygon();

		//Calcule des deux bases

		//Sens de la fleche

		//Pointe
		Point p2=new Point((int) Math.round(p.x+r*Math.cos(theta)),
						 (int) Math.round(p.y-r*Math.sin(theta)));
		arrow.addPoint(p2.x,p2.y);
		arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta + alpha) ),
		  (int) Math.round( p2.y+r*Math.sin(theta + alpha) ));

		//Base2
		arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta - alpha) ),
		  (int) Math.round( p2.y+r*Math.sin(theta - alpha) ));
     */

    public Polygon getShape() {

        Polygon arrow = new Polygon();
//        arrow.addPoint(turtle.getX(), turtle.getY());

        double ratioDegRad = turtle.ratioDegRad;

        //Angle de la droite
        double theta=ratioDegRad*(-turtle.getDir());

        float rb = turtle.rb, rp = turtle.rp;

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
