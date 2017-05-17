package com.polytech.turtle.environment;

import com.polytech.turtle.model.ITurtle;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 5/16/2017.
 */
public class AutomaticIEnvironment implements IEnvironment {
    private List<ITurtle> listTurtle;
    private Thread thread;
    private int refreshRate;
    private Boolean stop;

    public List<ITurtle> getListTurtle() {
        return listTurtle;
    }

    public void setListTurtle(List<ITurtle> listTurtle) {
        this.listTurtle = listTurtle;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    public AutomaticIEnvironment(List<ITurtle> listTurtle, int refreshRate) {
        this.listTurtle = listTurtle;
        this.refreshRate = refreshRate;
        this.stop = false;
    }

    @Override
    public Runnable task() {
        return () -> {
            while(!stop)
            {
                listTurtle.forEach(ITurtle::moveRandom);
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
        stop = true;
        thread.interrupt();
        Thread.currentThread().interrupt(); // restore interrupted status

    }
}
