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
    private final int MAX_SPEED = 20;
    public final int MAX_DISTANCE = 10;
    private final int MAX_ANGLE = 360;


    public static final int ARROW_HEIGHT = 10, ARROW_BASE_WIDTH = 5; // Taille de la pointe et de la base de la fleche

    private ArrayList<Segment> listSegments; // Trace de la fr.polytech.turtle
    private Point position;
    private int speed;
    private int direction;
    private boolean pen;
    private Color color;


    public Turtle() {
        listSegments = new ArrayList<>();
        this.setSpeed();
        reset();
    }

    public Point getPosition() {
        return position;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setSpeed() {
        this.speed = new Random().nextInt(MAX_SPEED) + 1 ;
    }

    void notifyView() {
        this.setChanged();
        this.notifyObservers();
    }

    public void randonmise() {
        Random random = new Random();
        this.speed = random.nextInt(MAX_SPEED) + 1 ;
        this.position = new Point(random.nextInt(Sheet.DEFAULT_WIDTH), random.nextInt(Sheet.DEFAULT_HEIGHT));
        this. direction = new Random().nextInt(MAX_ANGLE);
        notifyView();
    }

    public void reset() {
        this.position = new Point(Sheet.DEFAULT_WIDTH/2, Sheet.DEFAULT_HEIGHT/2);
        direction = -90;
        this.setColor(DEFAULT_COLOR);
        pen = true;
        listSegments.clear();
        notifyView();
    }

    public void setPosition(Point point) {
        position.setX(point.getX());
        position.setY(point.getY());
        notifyView();
    }

    public void moveRandom() {
        Random random = new Random();
        int randomDistance = random.nextInt(MAX_DISTANCE) * this.speed;
        int randomAngle = random.nextInt(MAX_ANGLE);
        direction = (direction - randomAngle) % 360;
        this.nextColor();
        this.moveForward(randomDistance);
    }


    public void moveForward(int dist) {
        Point newPoint = newPoint(dist);

        if (pen) {
            Segment seg = new Segment(this.color, new Point(position.getX(), position.getY()), newPoint.clone());
            listSegments.add(seg);
        }

        int holdX = newPoint.getX();
        int holdY = newPoint.getY();

        // Toroidal
        newPoint = toroidal(newPoint);

        if(holdX > newPoint.getX()){
            position.setX(position.getX() - Sheet.DEFAULT_WIDTH);
        }else if(holdX < newPoint.getX()){
            position.setX(position.getX() + Sheet.DEFAULT_WIDTH);
        }else if(holdY > newPoint.getY()){
            position.setY(position.getY() - Sheet.DEFAULT_HEIGHT);
        }else if(holdY < newPoint.getY()){
            position.setY(position.getY() + Sheet.DEFAULT_HEIGHT);
        }

        if(holdX != newPoint.getX() || holdY != newPoint.getY()){
            Segment seg = new Segment(this.color, new Point(position.getX(), position.getY()), newPoint);
            listSegments.add(seg);
        }

        this.setPosition(newPoint);
    }

    public Point newPoint(int dist){
        return new Point((int) Math.round(position.getX() + dist * Math.cos(Math.toRadians(direction))),
                (int) Math.round(position.getY() + dist * Math.sin(Math.toRadians(direction))));
    }

    public Point toroidal(Point point){
        point.setX(point.getX() < 0 ? Sheet.DEFAULT_WIDTH + point.getX() : point.getX());
        point.setX(point.getX() > Sheet.DEFAULT_WIDTH ? point.getX() % Sheet.DEFAULT_WIDTH : point.getX());

        point.setY(point.getY() < 0 ? Sheet.DEFAULT_HEIGHT + point.getY() : point.getY());
        point.setY(point.getY() > Sheet.DEFAULT_HEIGHT ? point.getY() % Sheet.DEFAULT_HEIGHT : point.getY());
        return point;
    }

    public void turnRight(int ang) {
        direction = (direction + ang) % 360;
        notifyView();
    }

    public void turnLeft(int ang) {
        direction = (direction - ang) % 360;
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
        this.setColor(getRandomColor());
    }

    private Color getRandomColor(){
        return color = Colors.getColors().get(new Random().nextInt(Colors.getColors().size()));
    }
}
