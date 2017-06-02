package com.polytech.turtle.model;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Created by Matthieu on 02/06/2017.
 */
public class ObstacleTest {
    private final int MAX_WIDTH = 200;

    private Rectangle shape;
    private Color color;
    private Point start, end;

    private Turtle turtle;

    private Obstacle obstacle;
    @Before
    public void setUp() {
        this.start = new Point(28, 18);
        this.obstacle = new Obstacle(this.start);
        this.turtle = new Turtle();
    }

    @Test
    public void should_give_true_on_test_is_collide(){
        //Given
        Point p1 = new Point(28-MAX_WIDTH,18);
        Point p2 = new Point(28,18-MAX_WIDTH);
        Point p3 = new Point(29+MAX_WIDTH,10);
        Point p4 = new Point(28,19+MAX_WIDTH);
        //When
        this.turtle.setPosition(this.start);
        //Then
        assertThat(this.obstacle.isCollide(this.turtle)).isTrue();
        //When
        this.turtle.setPosition(p1);
        //Then
        assertThat(this.obstacle.isCollide(this.turtle)).isFalse();
        //When
        this.turtle.setPosition(p2);
        //Then
        assertThat(this.obstacle.isCollide(this.turtle)).isFalse();
        //When
        this.turtle.setPosition(p3);
        //Then
        assertThat(this.obstacle.isCollide(this.turtle)).isFalse();
        //When
        this.turtle.setPosition(p4);
        //Then
        assertThat(this.obstacle.isCollide(this.turtle)).isFalse();
    }
}
