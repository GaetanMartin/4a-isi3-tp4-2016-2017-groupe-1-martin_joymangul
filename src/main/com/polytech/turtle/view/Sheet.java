package com.polytech.turtle.view;// package logo;

import com.polytech.turtle.model.Segment;
import com.polytech.turtle.model.Turtle;

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
	private List<Turtle> turtles; // la liste des turtles enregistrees
	
	public Sheet() {
		turtles = new ArrayList<>();
		this.setBackground(Color.white);
		this.setSize(new Dimension(600, 400));
		this.setPreferredSize(new Dimension(600, 400));
	}

	public void addTortue(Turtle o) {
		o.addObserver(this);
		turtles.add(o);
		repaint();
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
