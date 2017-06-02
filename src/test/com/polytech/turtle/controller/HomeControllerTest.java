package com.polytech.turtle.controller;

import com.polytech.turtle.view.Home;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Matthieu on 02/06/2017.
 */
public class HomeControllerTest {
    private HomeController homeController;

    private TurtleController turtleController;

    @Before
    public void setUp() {
        try{
            this.homeController = new HomeController(mock(Home.class));
            this.turtleController = mock(TurtleController.class);
            this.homeController.setTurtleController(this.turtleController);
        }catch  (NullPointerException npe) {
            System.out.println("to catch exception graph");
        }
    }

    @Test
    @Ignore
    public void should_give_true_on_test_flocking_mode(){
        //Given
        //When
        try{
            this.homeController.flockingMode();
        }catch  (NullPointerException npe) {
            System.out.println("to catch exception graph");
        }
        //Then
        verify(this.turtleController, atLeastOnce()).flockingEnvironment();
    }

    @Ignore
    @Test
    public void should_give_true_on_test_automatic_mode(){
        //Given
        //When
        try{
            this.homeController.automaticMode();
        }catch  (NullPointerException npe) {
            System.out.println("to catch exception graph");
        }

        //Then
        verify(this.turtleController, atLeastOnce()).automaticEnvironment();
    }

    @Ignore
    @Test
    public void should_give_true_on_test_manual_mode(){
        //Given

        //When
        try{
            this.homeController.manualMode();
        }catch  (NullPointerException npe) {
            System.out.println("to catch exception graph");
        }

        //Then
        verify(this.turtleController, atLeastOnce()).controlledEnvironment();
    }
}
