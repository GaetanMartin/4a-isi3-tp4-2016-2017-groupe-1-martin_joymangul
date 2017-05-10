package main.com.polytech.turtle.model;

import com.polytech.turtle.model.Point;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Created by p1511785 on 10/05/2017.
 */
public class PointTest {
    private Point point;
    private int x, y;

    @Before
    public void setUp() {
        this.x = 5;
        this.y = 10;
        this.point = new Point(x,y);
    }

    @Test
    public void should_give_true_on_test_get_x(){
        //Given
        //When
        int xValue = point.getX();
        //Then
        assertThat(xValue == x).isTrue();
    }

    @Test
    public void should_give_true_on_test_get_y(){
        //Given
        //When
        int yValue = point.getY();
        //Then
        assertThat(yValue == y).isTrue();
    }
}