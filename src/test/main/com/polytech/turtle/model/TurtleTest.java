package main.com.polytech.turtle.model;

import com.polytech.turtle.model.Point;
import com.polytech.turtle.model.Segment;
import com.polytech.turtle.model.Turtle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by p1511785 on 10/05/2017.
 */
public class TurtleTest {
    private Turtle turtle;

    private ArrayList<Segment> listSegments;
    private Point position;
    private int dir;
    private boolean pen;
    private Color color;

    @Before
    public void setUp() {

        this.listSegments = new ArrayList<Segment>();
        for(int i = 0; i < 10; i++){
            Segment segment = mock(Segment.class);
            when(segment.getStart()).thenReturn(new Point(i,10-i));
            when(segment.getEnd()).thenReturn(new Point(10-i,i));
            when(segment.getColor()).thenReturn(new Color(173,255,47));
            this.listSegments.add(segment);
        }
        this.position = new Point(28, 18);
        this.color = new Color(173,255,47);
        this.turtle = new Turtle();
    }

/*
    @Test
    public void should_give_true_on_test_move(){
        //Given
        //When
        this.turtleController.move(1);
        //Then
        verify(this.turtleModel, atLeastOnce()).moveForward(any(Integer.class));
    }

    @Test
    public void should_give_true_on_test_right(){
        //Given
        //When
        this.turtleController.right(1);
        //Then
        verify(this.turtleModel, atLeastOnce()).turnRight(any(Integer.class));
    }

    @Test
    public void should_give_true_on_test_left(){
        //Given

        //When
        this.turtleController.left(1);
        //Then
        verify(this.turtleModel, atLeastOnce()).turnLeft(any(Integer.class));
    }

    @Test
    public void should_give_true_on_test_init_controller(){
        //Given

        //When
        //this.turtleController.initController();
        //Then
        //verify(this.turtleView, atLeastOnce()).setSheet(any(Sheet.class));
    }

/*
    @Test
    public void should_give_true_on_test_color(){
        //Given
        JComboBox jComboBox = mock(JComboBox.class);
        jComboBox.setSelectedItem();
        ActionEvent actionEvent = mock(ActionEvent.class);
        actionEvent.setSource(jComboBox);
        //When
        this.turtleController.setColor(actionEvent);
        //Then
        verify(this.turtleModel, atLeastOnce()).setColor(any(Color.class));
    }


    @After
    public void testApresTeste(){
    }
*/
}
