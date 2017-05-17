package com.polytech.turtle.environment;

import com.polytech.turtle.controller.TurtleController;
import com.polytech.turtle.model.Point;
import com.polytech.turtle.model.Segment;
import com.polytech.turtle.model.Turtle;
import com.polytech.turtle.model.TurtleInterface;
import com.polytech.turtle.view.MainGUI;
import com.polytech.turtle.view.Sheet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.*;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

/**
 * Created by p1511785 on 17/05/2017.
 */
public class FlockingEnvironmentTest {
    private FlockingEnvironment flockingEnvironment;

    private Turtle turtle;
    private List<TurtleInterface> listTurtle;

    @Before
    public void setUp() {

        this.turtle = mock(Turtle.class);
        this.listTurtle = new ArrayList<>(10);
        for(int i = 0; i < 10; i++){
            Turtle turtleNeighbours = mock(Turtle.class);
            this.listTurtle.add(turtleNeighbours);
        }
        flockingEnvironment = new FlockingEnvironment(listTurtle, 1);
        for (int i = 0; i < 10; i++) {
            when(flockingEnvironment.getDistance(turtle, listTurtle.get(i))).thenReturn(2);
        }
    }



    @Test
    public void should_give_true_on_test_get_neighbours(){
        //Given

        //When
        List<TurtleInterface> result = this.flockingEnvironment.getNeighbours(turtle);
        //Then
        System.out.printf("Size : " + result.size());
        assertThat(result.size() == 9).isTrue();
    }

    @After
    public void testApresTeste(){
    }

}
