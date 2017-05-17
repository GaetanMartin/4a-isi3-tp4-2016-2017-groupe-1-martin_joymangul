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

 **************************************************************************/


public class Turtle extends Observable implements TurtleInterface {
    private static final Color DEFAULT_COLOR = Color.BLACK;
    private final int MAX_SPEED = 20;
    public final int MAX_DISTANCE = 10;
    private final int MAX_ANGLE = 360;
    public static final int NUMBER_OF_TURTLE = 20;

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

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public int getDirection() {
        return direction;
    }

    @Override
    public void setDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
        notifyView();
    }

    @Override
    public Color getColor() {
        return color;
    }


    @Override
    public ArrayList<Segment> getListSegments() {
        return listSegments;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    private void setSpeed() {
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

    @Override
    public void reset() {
        this.position = new Point(Sheet.DEFAULT_WIDTH/2, Sheet.DEFAULT_HEIGHT/2);
        direction = -90;
        this.setColor(DEFAULT_COLOR);
        pen = true;
        listSegments.clear();
        notifyView();
    }

    @Override
    public void setPosition(Point point) {
        position.setX(point.getX());
        position.setY(point.getY());
        notifyView();
    }

    @Override
    public void moveRandom() {
        Random random = new Random();
        int randomDistance = random.nextInt(MAX_SPEED);
        int randomAngle = random.nextInt(MAX_ANGLE);
        direction = (direction - randomAngle) % 360;
        this.nextColor();
        this.moveForward(randomDistance);
    }


    @Override
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

    private Point newPoint(int dist){
        return new Point((int) Math.round(position.getX() + dist * Math.cos(Math.toRadians(direction))),
                (int) Math.round(position.getY() + dist * Math.sin(Math.toRadians(direction))));
    }

    private Point toroidal(Point point){
        point.setX(point.getX() < 0 ? Sheet.DEFAULT_WIDTH + point.getX() : point.getX());
        point.setX(point.getX() > Sheet.DEFAULT_WIDTH ? point.getX() % Sheet.DEFAULT_WIDTH : point.getX());

        point.setY(point.getY() < 0 ? Sheet.DEFAULT_HEIGHT + point.getY() : point.getY());
        point.setY(point.getY() > Sheet.DEFAULT_HEIGHT ? point.getY() % Sheet.DEFAULT_HEIGHT : point.getY());
        return point;
    }

    @Override
    public void turnRight(int ang) {
        direction = (direction + ang) % 360;
        notifyView();
    }

    @Override
    public void turnLeft(int ang) {
        direction = (direction - ang) % 360;
        notifyView();
    }

    @Override
    public void lowerPen() {
        pen = true;
        notifyView();
    }

    @Override
    public void liftPen() {
        pen = false;
        notifyView();
    }

    @Override
    public void addObserver(Sheet sheet) {
        super.addObserver(sheet);
    }

    public void nextColor() {
        this.setColor(getRandomColor());
    }

    private Color getRandomColor(){
        return color = Colors.getColors().get(new Random().nextInt(Colors.getColors().size()));
    }
}
