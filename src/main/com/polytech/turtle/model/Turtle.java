package main.com.polytech.turtle.model;// package logo;

import main.com.polytech.turtle.Utils.Colors;

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

    public static final int rp = 10, rb = 5; // Taille de la pointe et de la base de la fleche

    protected ArrayList<Segment> listSegments; // Trace de la fr.polytech.turtle
    protected int x;
    protected int y;
    protected int dir;
    protected boolean crayon;
    protected Color color;



    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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

    public Turtle() {
        listSegments = new ArrayList<>();
        reset();
    }

    private void notifyView() {
        this.setChanged();
        this.notifyObservers();
    }

    public void reset() {
        x = 0;
        y = 0;
        dir = -90;
        this.setColor(Color.BLACK);
        crayon = true;
        listSegments.clear();
        notifyView();
    }

    public void setPosition(int newX, int newY) {
        x = newX;
        y = newY;
        notifyView();
    }


    public void avancer(int dist) {
        int newX = (int) Math.round(x + dist * Math.cos(Math.toRadians(dir)));
        int newY = (int) Math.round(y + dist * Math.sin(Math.toRadians(dir)));

        if (crayon) {
            Segment seg = new Segment(this.color, new Point(x, y), new Point(newX, newY));
            listSegments.add(seg);
        }

        this.setPosition(newX, newY);
    }

    public void droite(int ang) {
        dir = (dir + ang) % 360;
        notifyView();
    }

    public void gauche(int ang) {
        dir = (dir - ang) % 360;
        notifyView();
    }

    public void baisserCrayon() {
        crayon = true;
        notifyView();
    }

    public void leverCrayon() {
        crayon = false;
        notifyView();
    }

    public void couleurSuivante() {
        // TODO : this
    }
}
