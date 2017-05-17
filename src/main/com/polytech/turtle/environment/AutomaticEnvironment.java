package com.polytech.turtle.environment;

import com.polytech.turtle.model.TurtleInterface;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 5/16/2017.
 */
public class AutomaticEnvironment implements EnvironmentInterface{
    private List<TurtleInterface> listTurtle;
    private Thread thread;
    private int refreshRate;

    public List<TurtleInterface> getListTurtle() {
        return listTurtle;
    }

    public void setListTurtle(List<TurtleInterface> listTurtle) {
        this.listTurtle = listTurtle;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    public AutomaticEnvironment(List<TurtleInterface> listTurtle, int refreshRate) {
        this.listTurtle = listTurtle;
        this.refreshRate = refreshRate;
    }

    @Override
    public Runnable task() {
        return () -> {
            while(true)
            {
                listTurtle.forEach(TurtleInterface::moveRandom);
                try {
                    TimeUnit.MILLISECONDS.sleep(refreshRate);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

        };
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
