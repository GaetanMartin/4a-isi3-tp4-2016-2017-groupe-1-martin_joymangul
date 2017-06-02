package com.polytech.turtle.model.environment;

import com.polytech.turtle.model.ITurtle;
import com.polytech.turtle.model.Obstacle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 5/16/2017.
 */
public class FlockingIEnvironment extends AbstractEnvironment{
    public FlockingIEnvironment(List<ITurtle> listTurtle, List<Obstacle> listObstacles, int refreshRate) {
        super(listTurtle, listObstacles, refreshRate);
    }

    @Override
    public Runnable task() {
        return () -> {

            while (!super.stop) {

                for (ITurtle turtle : super.getListTurtle()) {
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
                    super.avoidObstacle(turtle);
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(super.refreshRate);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

        };
    }

    protected List<ITurtle> getNeighbours(ITurtle currentTurtle) {
        List<ITurtle> result = new ArrayList<>();
        for (ITurtle turtle : this.getListTurtle()) {
            if (isNeighbour(currentTurtle, turtle)) {
                result.add(turtle);
            }
        }
        return result;
    }

    protected boolean isNeighbour(ITurtle currentTurtle, ITurtle turtle){
        if(turtle.getColor() == currentTurtle.getColor() && currentTurtle.getDistance(turtle) <= super.MAX_NEIGHBOUR_DISTANCE && currentTurtle.isInVision(turtle))
            return true;
        else
            return false;
    }


}
