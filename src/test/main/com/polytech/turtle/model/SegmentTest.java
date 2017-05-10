package main.com.polytech.turtle.model;

import com.polytech.turtle.model.Point;
import com.polytech.turtle.model.Segment;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by p1511785 on 10/05/2017.
 */
public class SegmentTest {
    private Segment segment;
    private Point start, end;
    private Color color;

    @Before
    public void setUp() {
        this.start = new Point(28, 18);
        this.end = new Point(28, 18);
        this.color = new Color(173,255,47);
        this.segment = new Segment(color, start, end);
    }

    @Test
    public void should_give_true_on_test_get_start(){
        //Given
        //When
        Point startBis = segment.getStart();
        //Then
        assertThat(startBis == start).isTrue();
    }

    @Test
    public void should_give_true_on_test_get_end(){
        //Given
        //When
        Point endBis = segment.getEnd();
        //Then
        assertThat(endBis == end).isTrue();
    }
}
