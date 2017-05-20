package com.polytech.turtle.environment;

import com.polytech.turtle.model.ITurtle;
import com.polytech.turtle.model.Obstacle;

import java.util.List;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 5/20/2017.
 */
public class ControlledEnvironment extends AbstractEnvironment{
    public ControlledEnvironment(List<ITurtle> listTurtle, List<Obstacle> listObstacles) {
        super(listTurtle, listObstacles, 0);
    }
}
