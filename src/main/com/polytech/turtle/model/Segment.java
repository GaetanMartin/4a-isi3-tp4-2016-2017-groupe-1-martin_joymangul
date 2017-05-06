package main.com.polytech.turtle.model;

/**
 * Created by p1509413 on 26/04/2017.
 * Segment
 */
public class Segment {

    private int color;

    private Point start;

    private Point end;

    public Segment(int color, Point start, Point end) {
        this.color = color;
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public int getColor() {
        return color;
    }
}
