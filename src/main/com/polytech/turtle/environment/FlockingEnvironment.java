package com.polytech.turtle.environment;

import com.polytech.turtle.model.Turtle;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 5/16/2017.
 */
public class FlockingEnvironment implements EnvironmentInterface {
    private final int MAX_NEIGHTBOUR_DISTANCE = 15;
    private final int NUMBER_OF_TURTLE = 20;
    private List<Turtle> listTurtle;
    private Thread thread;
    private int refreshRate;

    public List<Turtle> getListTurtle() {
        return listTurtle;
    }

    public void setListTurtle(List<Turtle> listTurtle) {
        this.listTurtle = listTurtle;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    public Thread getThread() {
        return thread;
    }


    public FlockingEnvironment(List<Turtle> listTurtle, int refreshRate) {
        this.listTurtle = listTurtle;
        this.refreshRate = refreshRate;
    }

    @Override
    public Runnable task() {
        Runnable task = () -> {

            while (true) {

                for (Turtle turtle : this.getListTurtle()) {
                    List<Turtle> neighbours = this.getNeighbours(turtle);
                    if (!neighbours.isEmpty()) {
                        Double avg_direction = neighbours
                                .stream()
                                .mapToInt(a -> a.getDirection())
                                .average()
                                .orElse(1);

                        Double avg_speed = neighbours
                                .stream()
                                .mapToInt(a -> a.getSpeed())
                                .average()
                                .orElse(1);

                        turtle.setSpeed(avg_speed.intValue());
                        turtle.setDirection(avg_direction.intValue());

                        turtle.moveForward(avg_speed.intValue());
                    } else {
                        turtle.moveRandom();
                    }
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(refreshRate);
                } catch (InterruptedException e) {

                }
            }

        };
        return task;
    }

    @Override
    public void start() {
        thread = new Thread(this.task());
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
        Thread.currentThread().interrupt(); // restore interrupted status
    }

    private List<Turtle> getNeighbours(Turtle currentTurtle) {
        List<Turtle> result = new ArrayList<>();
        for (Turtle turtle : this.getListTurtle()) {
            if (this.getDistance(currentTurtle, turtle) <= MAX_NEIGHTBOUR_DISTANCE) {
                result.add(turtle);
            }
        }
        return result;
    }

    private int getDistance(Turtle source, Turtle destination) {
        return (int) Math.sqrt(Math.pow(destination.getPosition().getX() - source.getPosition().getX(), 2) + Math.pow(destination.getPosition().getY() - source.getPosition().getY(), 2));
    }
}
