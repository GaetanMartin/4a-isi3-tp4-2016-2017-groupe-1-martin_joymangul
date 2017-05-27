package com.polytech.turtle.model.environment;

import com.polytech.turtle.model.ITurtle;
import com.polytech.turtle.model.Obstacle;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 5/16/2017.
 */
public class AutomaticIEnvironment extends AbstractEnvironment {
    public AutomaticIEnvironment(List<ITurtle> listTurtle, List<Obstacle> listObstacles, int refreshRate) {
        super(listTurtle, listObstacles, refreshRate);
    }

    @Override
    public Runnable task() {
        return () -> {
            while(!stop)
            {
                for (ITurtle turtle : super.getListTurtle()) {
                    turtle.moveRandom();
                    super.avoidObstacle(turtle);
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(refreshRate);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

            }

        };
    }

}
