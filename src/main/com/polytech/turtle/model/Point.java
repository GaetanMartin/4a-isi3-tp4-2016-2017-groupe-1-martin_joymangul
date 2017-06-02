package com.polytech.turtle.model;

import static java.lang.Math.pow;

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
        return (int) Math.sqrt(pow(destination.getX() - this.getX(), 2) + pow(destination.getY() - this.getY(), 2));
    }

    public int getAngle(Point direction, Point otherTurtle){
        int a = this.getDistance(direction);
        int c = direction.getDistance(otherTurtle);
        int b = this.getDistance(otherTurtle);
        if(a==0 || b==0 || c==0){
            return 0;
        }
        double result = (-(pow(c,2)-pow(a,2)-pow(b,2))/(2*a*c));
        double radian =Math.acos(result);
        double result_bis = Math.toDegrees(radian);
        return (int) result_bis;
    }
}
