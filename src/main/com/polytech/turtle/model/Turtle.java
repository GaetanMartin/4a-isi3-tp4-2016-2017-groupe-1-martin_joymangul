package com.polytech.turtle.model;// package logo;

import com.polytech.turtle.Utils.Colors;
import com.polytech.turtle.view.Sheet;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;


/*************************************************************************

 Un petit Logo minimal qui devra etre ameliore par la suite

 Source originale : J. Ferber - 1999-2001

 Cours de DESS TNI - Montpellier II

 @version 2.0
 @date 25/09/2001

 **************************************************************************/


public class Turtle extends Observable {
    private static final Color DEFAULT_COLOR = Color.BLACK;
    private final int MAX_DISTANCE = 150;
    private final int MAX_ANGLE = 360;

    public static final int ARROW_HEIGHT = 10, ARROW_BASE_WIDTH = 5; // Taille de la pointe et de la base de la fleche

    private ArrayList<Segment> listSegments; // Trace de la fr.polytech.turtle
    private Point position;
    private int dir;
    private boolean pen;
    private Color color;


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


    void notifyView() {
        this.setChanged();
        this.notifyObservers();
    }

    public void reset() {
        this.position = new Point(Sheet.DEFAULT_WIDTH/2, Sheet.DEFAULT_HEIGHT/2);
        dir = -90;
        this.setColor(DEFAULT_COLOR);
        pen = true;
        listSegments.clear();
        notifyView();
    }

    public void setPosition(int newX, int newY) {
        position.setX(newX);
        position.setY(newY);
        notifyView();
    }

    public void moveRandom() {
        Random random = new Random();
        int randomDistance = random.nextInt(MAX_DISTANCE);
        int randomAngle = random.nextInt(MAX_ANGLE);
        this.turnLeft(randomAngle);
        this.moveForward(randomDistance);
    }


    public void moveForward(int dist) {
        int newX = (int) Math.round(position.getX() + dist * Math.cos(Math.toRadians(dir)));
        int newY = (int) Math.round(position.getY() + dist * Math.sin(Math.toRadians(dir)));

        if (pen) {
            Segment seg = new Segment(this.color, new Point(position.getX(), position.getY()), new Point(newX, newY));
            listSegments.add(seg);
        }

        // Toroidal b
        newX = newX < 0 ? Sheet.DEFAULT_WIDTH + newX : newX;
        newX = newX > Sheet.DEFAULT_WIDTH ? newX % Sheet.DEFAULT_WIDTH : newX;

        newY = newY < 0 ? Sheet.DEFAULT_HEIGHT + newY : newY;
        newY = newY > Sheet.DEFAULT_HEIGHT ? newY % Sheet.DEFAULT_HEIGHT : newY;

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
        Color color = Colors.getColors().get(new Random().nextInt(Colors.getColors().size()));
        this.setColor(color);
    }
}
