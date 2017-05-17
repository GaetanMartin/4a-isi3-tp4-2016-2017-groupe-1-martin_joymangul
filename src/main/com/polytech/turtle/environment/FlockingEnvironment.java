package com.polytech.turtle.environment;

import com.polytech.turtle.model.TurtleInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 5/16/2017.
 */
public class FlockingEnvironment implements EnvironmentInterface {
    private final int MAX_NEIGHTBOUR_DISTANCE = 15;
    private final int NUMBER_OF_TURTLE = 20;
    private List<TurtleInterface> listTurtle;
    private Thread thread;
    private int refreshRate;
    private Boolean stop;

    private List<TurtleInterface> getListTurtle() {
        return listTurtle;
    }

    public FlockingEnvironment(List<TurtleInterface> listTurtle, int refreshRate) {
        this.listTurtle = listTurtle;
        this.refreshRate = refreshRate;
        this.stop = false;
    }

    @Override
    public Runnable task() {
        return () -> {

            while (!stop) {

                for (TurtleInterface turtle : this.getListTurtle()) {
                    List<TurtleInterface> neighbours = this.getNeighbours(turtle);
                    if (!neighbours.isEmpty()) {
                        Double avg_direction = neighbours
                                .stream()
                                .mapToInt(TurtleInterface::getDirection)
                                .average()
                                .orElse(1);

                        Double avg_speed = neighbours
                                .stream()
                                .mapToInt(TurtleInterface::getSpeed)
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
                    Thread.currentThread().interrupt();
                }
            }

        };
    }

    @Override
    public void start() {
        thread = new Thread(this.task());
        thread.start();
    }

    @Override
    public void stop() {
        stop = true;
        thread.interrupt();
        Thread.currentThread().interrupt(); // restore interrupted status
    }

    protected List<TurtleInterface> getNeighbours(TurtleInterface currentTurtle) {
        List<TurtleInterface> result = new ArrayList<>();
        for (TurtleInterface turtle : this.getListTurtle()) {
            if (this.getDistance(currentTurtle, turtle) <= MAX_NEIGHTBOUR_DISTANCE) {
                result.add(turtle);
            }
        }
        return result;
    }

    protected int getDistance(TurtleInterface source, TurtleInterface destination) {
        return (int) Math.sqrt(Math.pow(destination.getPosition().getX() - source.getPosition().getX(), 2) + Math.pow(destination.getPosition().getY() - source.getPosition().getY(), 2));
    }
}
