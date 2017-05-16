package com.polytech.turtle.environment;

import com.polytech.turtle.model.Turtle;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 5/16/2017.
 */
public class AutomaticEnvironment implements EnvironmentInterface{
    private List<Turtle> listTurtle;
    private Thread thread;
    private int speed;

    public List<Turtle> getListTurtle() {
        return listTurtle;
    }

    public void setListTurtle(List<Turtle> listTurtle) {
        this.listTurtle = listTurtle;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public AutomaticEnvironment(List<Turtle> listTurtle, int speed) {
        this.listTurtle = listTurtle;
        this.speed = speed;
    }

    @Override
    public Runnable task() {
        Runnable task = () -> {
            while(true)
            {
                listTurtle.forEach((Turtle turtle) -> turtle.moveRandom());
                try {
                    TimeUnit.MILLISECONDS.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
        return task;
    }

    public void start(){
        thread = new Thread(this.task());
        thread.start();
    }

    @Override
    public void stop() {
        this.thread.interrupt();
    }
}
