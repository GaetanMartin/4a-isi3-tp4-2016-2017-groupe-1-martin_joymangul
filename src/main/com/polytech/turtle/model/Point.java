package com.polytech.turtle.model;

/**
 * Created by p1509413 on 26/04/2017.
 */
public class Point implements Cloneable {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point clone(){
        try {
            return (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.printf("Can't clone point");
            e.printStackTrace();
            return null;
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDistance(Point destination){
        return (int) Math.sqrt(Math.pow(destination.getX() - this.getX(), 2) + Math.pow(destination.getY() - this.getY(), 2));
    }
}
