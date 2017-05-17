package com.polytech.turtle.environment;

import com.polytech.turtle.model.Turtle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 5/16/2017.
 */
public class AutomaticEnvironment implements EnvironmentInterface{
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

    public AutomaticEnvironment(List<Turtle> listTurtle, int refreshRate) {
        this.listTurtle = listTurtle;
        this.refreshRate = refreshRate;
    }

    @Override
    public Runnable task() {
        Runnable task = () -> {


            while(true)
            {
                listTurtle.forEach((Turtle turtle) -> turtle.moveRandom());
                try {
                    TimeUnit.MILLISECONDS.sleep(refreshRate);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
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
        thread.interrupt();
        Thread.currentThread().interrupt(); // restore interrupted status

    }
}
