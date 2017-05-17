package com.polytech.turtle.environment;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 5/16/2017.
 */
public interface IEnvironment {

    Runnable task();

    void start();

    void stop();
}
