package com.polytech.turtle.environment;

import com.polytech.turtle.model.ITurtle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

/**
 * Created by matthieu moisson on 17/05/2017.
 *
 */
public class FlockingEnvironmentTest {
    private FlockingIEnvironment flockingEnvironment;

    private ITurtle turtle;
    private List<ITurtle> listTurtle;

    @Before
    public void setUp() {

        this.turtle = mock(ITurtle.class);
        this.listTurtle = new ArrayList<>(10);
        for(int i = 0; i < 10; i++){
            ITurtle turtleNeighbours = mock(ITurtle.class);
            this.listTurtle.add(turtleNeighbours);
        }
        flockingEnvironment = new FlockingIEnvironment(listTurtle, 1);
        for (int i = 0; i < 10; i++) {
            when(turtle.getDistance(listTurtle.get(i))).thenReturn(2*i);
        }
    }



    @Test
    public void should_give_true_on_test_get_neighbours(){
        //Given

        //When
        List<ITurtle> result = this.flockingEnvironment.getNeighbours(turtle);
        //Then
        System.out.printf("Size : " + result.size());
        assertThat(result.size() == 6).isTrue();
    }

    @After
    public void testApresTeste(){

    }

}
