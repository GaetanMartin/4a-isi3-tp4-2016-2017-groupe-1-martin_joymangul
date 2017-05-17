package com.polytech.turtle.view;// package logo;

import com.polytech.turtle.controller.TurtleController;
import com.polytech.turtle.model.Segment;
import com.polytech.turtle.model.Turtle;
import com.polytech.turtle.view.events.MouseAdapterCustom;

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

	private List<Turtle> turtles = new ArrayList<>(); // la liste des turtles enregistrees
	private Map<Turtle, TurtleView> turtleViewMap = new HashMap<>();


	public Sheet() {
		this.setBackground(Color.white);
		this.setSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		this.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
	}

	public void addTurtle(Turtle turtle) {
		turtle.addObserver(this);
		turtles.add(turtle);
		TurtleView turtleView = new TurtleView(turtle);
		turtleViewMap.put(turtle, turtleView);
		this.addMouseListener(new MouseAdapterCustom(turtle, turtleView));
		repaint();
	}

	public List<Turtle> getTurtles() {
		return turtles;
	}

	public void reset() {
		Turtle first = turtles.get(0);
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

		drawTurtles(g);
	}

	private void drawTurtles(Graphics g) {
		turtles.forEach((Turtle turtle) -> drawTurtle(turtle, g));
	}

	private void drawTurtle(Turtle t, Graphics g) {
		Polygon arrow = turtleViewMap.get(t).getShape();
		g.setColor(t.getColor());
		g.fillPolygon(arrow);
		drawSegments(g, t.getListSegments());
	}

	private void drawSegments(Graphics graph, ArrayList<Segment> listSegment)
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
