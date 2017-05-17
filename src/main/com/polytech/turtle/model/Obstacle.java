package com.polytech.turtle.model;

import com.polytech.turtle.Utils.Colors;
import com.polytech.turtle.view.Sheet;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Obstacle extends Observable {
    private List points;
    private Color color;

    public List getPoints() {
        return points;
    }

    public void setPoints(List points) {
        this.points = points;
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Obstacle()
    {
        this.setColor(this.getRandomColor());
    }

    private void buildPoints() {
        // TODO
        notifyView();
    }

    private Color getRandomColor(){
        return color = Colors.getColors().get(new Random().nextInt(Colors.getColors().size()));
    }

    public Boolean isCollide(Turtle turle) {
        // TODO
        return true;
    }

    void notifyView() {
        this.setChanged();
        this.notifyObservers();
    }

    public void addObserver(Sheet sheet) {
        super.addObserver(sheet);
    }
}
