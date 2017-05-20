package com.polytech.turtle.environment;

import com.polytech.turtle.model.ITurtle;
import com.polytech.turtle.model.Obstacle;

import java.util.List;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 5/20/2017.
 */
public abstract class AbstractEnvironment {
    protected final int MAX_NEIGHBOUR_DISTANCE = 20;
    private List<ITurtle> listTurtle;
    private List<Obstacle> listObstacles;
    public Thread thread;
    protected int refreshRate;
    protected Boolean stop;

    protected List<ITurtle> getListTurtle() {
        return listTurtle;
    }

    protected List<Obstacle> getListObstacles() {
        return listObstacles;
    }

    public AbstractEnvironment(List<ITurtle> listTurtle, List<Obstacle> listObstacles, int refreshRate) {
        this.listTurtle = listTurtle;
        this.listObstacles = listObstacles;
        this.refreshRate = refreshRate;
        this.stop = false;
    }

    public Runnable task() {
        return () -> {
            this.listTurtle.clear();
            this.listObstacles.clear();

        };
    }

    protected void avoidObstacle(ITurtle turtle){
        for(Obstacle obstacle : this.getListObstacles())
        {
            if(obstacle.isCollide(turtle)){
                turtle.setDirection(turtle.getDirection() + 180 );
            }
        }
    }

    public void start() {
        thread = new Thread(this.task());
        thread.start();
    }

    public void stop() {
        stop = true;
        thread.interrupt();
        Thread.currentThread().interrupt(); // restore interrupted status
    }
}
