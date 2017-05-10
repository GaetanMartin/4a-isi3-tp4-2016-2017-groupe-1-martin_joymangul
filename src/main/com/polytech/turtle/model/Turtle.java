package com.polytech.turtle.model;// package logo;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;


/*************************************************************************

 Un petit Logo minimal qui devra etre ameliore par la suite

 Source originale : J. Ferber - 1999-2001

 Cours de DESS TNI - Montpellier II

 @version 2.0
 @date 25/09/2001

 **************************************************************************/


public class Turtle extends Observable {

    public static final int ARROW_HEIGHT = 10, ARROW_BASE_WIDTH = 5; // Taille de la pointe et de la base de la fleche

    protected ArrayList<Segment> listSegments; // Trace de la fr.polytech.turtle
    protected Point position;
    protected int dir;
    protected boolean pen;
    protected Color color;


    public Turtle() {
        listSegments = new ArrayList<>();
        reset();
    }

    public Point getPosition() {
        return position;
    }

    public int getDir() {
        return dir;
    }

    public void setColor(Color color) {
        this.color = color;
        notifyView();
    }

    public Color getColor() {
        return color;
    }


    public ArrayList<Segment> getListSegments() {
        return listSegments;
    }


    protected void notifyView() {
        this.setChanged();
        this.notifyObservers();
    }

    public void reset() {
        this.position = new Point(300, 200);
        dir = -90;
        this.setColor(Color.BLACK);
        pen = true;
        listSegments.clear();
        notifyView();
    }

    public void setPosition(int newX, int newY) {
        position.setX(newX);
        position.setY(newY);
        notifyView();
    }


    public void moveForward(int dist) {
        int newX = (int) Math.round(position.getX() + dist * Math.cos(Math.toRadians(dir)));
        int newY = (int) Math.round(position.getY() + dist * Math.sin(Math.toRadians(dir)));

        if (pen) {
            Segment seg = new Segment(this.color, new Point(position.getX(), position.getY()), new Point(newX, newY));
            listSegments.add(seg);
        }

        this.setPosition(newX, newY);
    }

    public void turnRight(int ang) {
        dir = (dir + ang) % 360;
        notifyView();
    }

    public void turnLeft(int ang) {
        dir = (dir - ang) % 360;
        notifyView();
    }

    public void lowerPen() {
        pen = true;
        notifyView();
    }

    public void liftPen() {
        pen = false;
        notifyView();
    }

    public void nextColor() {
        // TODO : this
    }
}
