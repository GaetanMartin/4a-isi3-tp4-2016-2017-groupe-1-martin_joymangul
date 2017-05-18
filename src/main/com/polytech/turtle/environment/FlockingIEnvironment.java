package com.polytech.turtle.environment;

import com.polytech.turtle.model.ITurtle;
import com.polytech.turtle.model.Obstacle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 5/16/2017.
 */
public class FlockingIEnvironment implements IEnvironment {
    private final int MAX_NEIGHBOUR_DISTANCE = 20;
    private List<ITurtle> listTurtle;
    private List<Obstacle> listObstacles;
    private Thread thread;
    private int refreshRate;
    private Boolean stop;

    private List<ITurtle> getListTurtle() {
        return listTurtle;
    }

    public List<Obstacle> getListObstacles() {
        return listObstacles;
    }

    public FlockingIEnvironment(List<ITurtle> listTurtle, List<Obstacle> listObstacles, int refreshRate) {
        this.listTurtle = listTurtle;
        this.listObstacles = listObstacles;
        this.refreshRate = refreshRate;
        this.stop = false;
    }

    @Override
    public Runnable task() {
        return () -> {

            while (!stop) {

                for (ITurtle turtle : this.getListTurtle()) {
                    List<ITurtle> neighbours = this.getNeighbours(turtle);
                    if (!neighbours.isEmpty()) {
                        Double avg_direction = neighbours
                                .stream()
                                .mapToInt(ITurtle::getDirection)
                                .average()
                                .orElse(1);

                        Double avg_speed = neighbours
                                .stream()
                                .mapToInt(ITurtle::getSpeed)
                                .average()
                                .orElse(1);

                        turtle.setSpeed(avg_speed.intValue());
                        turtle.setDirection(avg_direction.intValue());

                        turtle.moveForward(avg_speed.intValue());
                    } else {
                        turtle.moveRandom();
                    }
                    for(Obstacle obstacle : this.listObstacles)
                    {
                        if(obstacle.isCollide(turtle)){
                            turtle.setDirection(-turtle.getDirection());
                        }
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

    protected List<ITurtle> getNeighbours(ITurtle currentTurtle) {
        List<ITurtle> result = new ArrayList<>();
        for (ITurtle turtle : this.getListTurtle()) {
            if (currentTurtle.getDistance(turtle) <= MAX_NEIGHBOUR_DISTANCE && turtle.getColor() == currentTurtle.getColor()) {
                result.add(turtle);
            }
        }
        return result;
    }


}
