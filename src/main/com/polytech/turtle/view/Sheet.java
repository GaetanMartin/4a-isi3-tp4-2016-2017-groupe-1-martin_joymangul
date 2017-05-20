package com.polytech.turtle.view;// package logo;

import com.polytech.turtle.controller.TurtleController;
import com.polytech.turtle.model.ITurtle;
import com.polytech.turtle.model.Obstacle;
import com.polytech.turtle.model.Segment;
import com.polytech.turtle.view.events.TurtleSelector;
import com.polytech.turtle.view.shapes.TurtleView;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Titre :        Logo
 * Description :  Un exemple de programme graphique utilisant la celebre Turtle Logo
 * Copyright :    Copyright (c) 2000
 * Societe :      LIRMM
 * @author J. Ferber
 * @version 2.0
 */

public class Sheet extends JPanel implements Observer {
	public static final int DEFAULT_WIDTH = 600;
	public static final int DEFAULT_HEIGHT = 400;

	private List<ITurtle> turtles = new ArrayList<>(); // la liste des turtles enregistrees
	private Map<ITurtle, TurtleView> turtleViewMap = new HashMap<>();
	private List<Obstacle> obstacles = new ArrayList<>();

	public List<Obstacle> getObstacles() {
		return obstacles;
	}

	public Sheet() {
		this.setBackground(Color.white);
		this.setSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		this.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
	}

	public void addObstacle(Obstacle obstacle) {
	    obstacle.addObserver(this);
	    this.obstacles.add(obstacle);
    }

	public void addTurtle(ITurtle turtle) {
		turtle.addObserver(this);
		turtles.add(turtle);
		TurtleView turtleView = new TurtleView(turtle);
		turtleViewMap.put(turtle, turtleView);
		this.addMouseListener(new TurtleSelector(turtle, turtleView));
		repaint();
	}

	public List<ITurtle> getTurtles() {
		return turtles;
	}

	public void reset() {
        ITurtle first = turtles.get(0);
        turtleViewMap.clear();
        obstacles.clear();
		turtles.clear();
		first.reset();
		TurtleController.setCurrentTurtle(first);
		this.addTurtle(first);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Color c = g.getColor();
		
		Dimension dim = getSize();
		g.setColor(Color.white);
		g.fillRect(0,0,dim.width, dim.height);
        g.setColor(c);

        try{
			drawTurtles(g);
			drawObstacles(g);
		} catch (ConcurrentModificationException e){
			System.out.println("Repaint is too fast");
		}

	}

    private void drawObstacles(Graphics g) {
        obstacles.forEach((Obstacle obstacle) -> drawObstacle(obstacle, g));
    }


    private void drawObstacle(Obstacle obstacle, Graphics g) {
        g.setColor(obstacle.getColor());
	    g.fillRect(obstacle.getShape().x, obstacle.getShape().y, obstacle.getShape().width, obstacle.getShape().height);
    }

	private void drawTurtles(Graphics g) {
		turtles.forEach((ITurtle turtle) -> drawTurtle(turtle, g));
	}

	private void drawTurtle(ITurtle t, Graphics g) {
		Polygon arrow = turtleViewMap.get(t).getShape();
		g.setColor(t.getColor());
		g.fillPolygon(arrow);
		drawSegments(g, t.getListSegments());
	}

	private void drawSegments(Graphics graph, LinkedList<Segment> listSegment)
	{
		listSegment.forEach((Segment segment) -> drawSegment(graph, segment));
	}

	private void drawSegment(Graphics graph, Segment segment) {
        graph.setColor(segment.getColor());
		graph.drawLine(segment.getStart().getX(), segment.getStart().getY(), segment.getEnd().getX(), segment.getEnd().getY());
	}

	@Override
	public void update(Observable o, Object arg) {
        revalidate();
		repaint();
	}
}
