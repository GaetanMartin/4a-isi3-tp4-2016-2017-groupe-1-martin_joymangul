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
    private Home home;

    private TurtleController turtleController;

    @Before
    public void setUp() {
        this.home = new Home("test");
        this.homeController = new HomeController(mock(Home.class));
        this.turtleController = mock(TurtleController.class);
        this.turtleController = mock(TurtleController.class);
        this.homeController.setTurtleController(this.turtleController);
    }

    @Test
    @Ignore
    public void should_give_true_on_test_flocking_mode(){
        //Given
        //When
        this.homeController.flockingMode();
        //Then
        verify(this.turtleController, atLeastOnce()).flockingEnvironment();
    }

    @Test
    @Ignore
    public void should_give_true_on_test_automatic_mode(){
        //Given
        //When
        this.homeController.automaticMode();
        //Then
        verify(this.turtleController, atLeastOnce()).automaticEnvironment();
    }

    @Test
    @Ignore
    public void should_give_true_on_test_manual_mode(){
        //Given

        //When
        this.homeController.manualMode();
        //Then
        verify(this.turtleController, atLeastOnce()).controlledEnvironment();
    }
}
