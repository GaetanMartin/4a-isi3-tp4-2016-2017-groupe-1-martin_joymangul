package com.polytech.turtle.controller;

import static org.junit.Assert.*;

import com.polytech.turtle.controller.TurtleController;
import com.polytech.turtle.model.Turtle;
import com.polytech.turtle.view.MainGUI;
import com.polytech.turtle.view.Sheet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static org.mockito.Mockito.*;

/**
 * Created by p1511785 on 10/05/2017.
 */
public class TurtleControllerTest {
    private TurtleController turtleController;

    private Turtle turtleModel;
    private MainGUI turtleView;
    private Sheet turtlePanel;

    @Before
    public void setUp() {

        this.turtleModel = mock(Turtle.class);
        this.turtleView = mock(MainGUI.class);
        this.turtlePanel = mock(Sheet.class);
        this.turtleController = new TurtleController(this.turtleModel, this.turtleView);
    }

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
*/

    @After
    public void testApresTeste(){
    }
}