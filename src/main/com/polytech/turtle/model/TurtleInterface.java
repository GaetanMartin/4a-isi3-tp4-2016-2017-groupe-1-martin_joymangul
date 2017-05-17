package com.polytech.turtle.model;

import com.polytech.turtle.view.Sheet;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by p1509413 on 17/05/2017.
 * Turtle Interface
 */
public interface TurtleInterface {

    int ARROW_HEIGHT = 10, ARROW_BASE_WIDTH = 5; // Taille de la pointe et de la base de la fleche

    Point getPosition();

    int getDirection();

    void setDirection(int direction);

    void setColor(Color color);

    Color getColor();

    ArrayList<Segment> getListSegments();

    int getSpeed();

    void setSpeed(int speed);

    void reset();

    void setPosition(Point point);

    void moveRandom();

    void moveForward(int dist);

    void turnRight(int ang);

    void turnLeft(int ang);

    void lowerPen();

    void liftPen();

    void addObserver(Sheet sheet);

    void nextColor();
}