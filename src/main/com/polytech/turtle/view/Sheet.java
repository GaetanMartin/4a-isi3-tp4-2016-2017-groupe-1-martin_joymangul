package com.polytech.turtle.view;// package logo;

import com.polytech.turtle.model.Segment;
import com.polytech.turtle.model.Turtle;
import com.polytech.turtle.view.events.MouseAdapterCustom;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

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

	private List<Turtle> turtles; // la liste des turtles enregistrees
	
	public Sheet() {
		turtles = new ArrayList<>();
		this.setBackground(Color.white);
		this.setSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		this.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
	}

	public void addTortue(Turtle o) {
		o.addObserver(this);
		turtles.add(o);
		repaint();
	}

	public List<Turtle> getTurtles() {
		return turtles;
	}

	public void reset() {
		turtles.forEach(Turtle::reset);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Color c = g.getColor();
		
		Dimension dim = getSize();
		g.setColor(Color.white);
		g.fillRect(0,0,dim.width, dim.height);
        g.setColor(c);

		showTurtles(g);
	}

	public void showTurtles(Graphics g) {
		for(Turtle t : turtles) {
            g.setColor(t.getColor());
			TurtleView turtleView = new TurtleView(t);
			Polygon arrow = turtleView.getShape();
			this.addMouseListener(new MouseAdapterCustom(t, turtleView));
			g.fillPolygon(arrow);
			drawSegments(g, t.getListSegments());
		}
	}

	public void drawSegments(Graphics graph, ArrayList<Segment> listSegment)
	{
		listSegment.stream().forEach((Segment segment) -> drawSegment(graph, segment));
	}

	public void drawSegment(Graphics graph, Segment segment) {
        graph.setColor(segment.getColor());
		graph.drawLine(segment.getStart().getX(), segment.getStart().getY(), segment.getEnd().getX(), segment.getEnd().getY());
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Repaint");
		repaint();
	}
}
