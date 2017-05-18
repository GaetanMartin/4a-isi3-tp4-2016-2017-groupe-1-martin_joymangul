package com.polytech.turtle.model;

import com.polytech.turtle.Utils.Colors;
import com.polytech.turtle.view.Sheet;

import java.awt.*;
import java.util.Observable;
import java.util.Random;

public class Obstacle extends Observable {
    private final int MAX_EDGES = 3;
    private final int MAX_WIDTH = 200;

    private Rectangle shape;
    private Color color;

    public Rectangle getShape() {
        return shape;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Obstacle(Point startPoint) {
        int width = new Random().nextInt(MAX_WIDTH);
        int height = new Random().nextInt(MAX_WIDTH);
        this.shape = new Rectangle(startPoint.getX(), startPoint.getY(), width, height);
        this.setColor(this.getRandomColor());
    }

    private Point randomPoint() {
        int randomX = new Random().nextInt(MAX_WIDTH);
        int randomY = new Random().nextInt(MAX_WIDTH);
        return new Point(randomX, randomY);
    }

    private Color getRandomColor(){
        return color = Colors.getColors().get(new Random().nextInt(Colors.getColors().size()));
    }

    public Boolean isCollide(Turtle turle) {
        // TODO
        return true;
    }

    public void notifyView() {
        this.setChanged();
        this.notifyObservers();
    }

    public void addObserver(Sheet sheet) {
        super.addObserver(sheet);
    }
}
