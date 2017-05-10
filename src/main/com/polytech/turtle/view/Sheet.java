package main.com.polytech.turtle.view;// package logo;

import main.com.polytech.turtle.model.Segment;
import main.com.polytech.turtle.model.Turtle;

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
		turtles = new ArrayList<Turtle>();
		this.setBackground(Color.white);
		this.setSize(new Dimension(600, 400));
		this.setPreferredSize(new Dimension(600, 400));
	}

	public void addTortue(Turtle o) {
		o.addObserver(this);
		turtles.add(o);
	}

	public void reset() {
		for (Iterator it = turtles.iterator(); it.hasNext();) {
			Turtle t = (Turtle) it.next();
			t.reset();
		}
	}

	/*


	public void drawTurtle (Graphics graph) {
		if (graph==null)
			return;

		// Dessine les segments
		for(Iterator it = listSegments.iterator();it.hasNext();) {
			Segment seg = (Segment) it.next();
			seg.drawSegment(graph);
		}



		arrow.addPoint(p2.x,p2.y);
		graph.setColor(Color.green);
		graph.fillPolygon(arrow);
    }

*/
    protected Color decodeColor(int c) {
		switch(c) {
			case 0: return(Color.black);
			case 1: return(Color.blue);
			case 2: return(Color.cyan);
			case 3: return(Color.darkGray);
			case 4: return(Color.red);
			case 5: return(Color.green);
			case 6: return(Color.lightGray);
			case 7: return(Color.magenta);
			case 8: return(Color.orange);
			case 9: return(Color.gray);
			case 10: return(Color.pink);
			case 11: return(Color.yellow);
			default : return(Color.black);
		}
	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Color c = g.getColor();
		
		Dimension dim = getSize();
		g.setColor(Color.white);
		g.fillRect(0,0,dim.width, dim.height);
        g.setColor(c);

//		graph.setColor(color);
//		graph.drawLine(ptStart.x, ptStart.y, ptEnd.x, ptEnd.y);
		showTurtles(g);
	}

	public void showTurtles(Graphics g) {
		for(Iterator it = turtles.iterator(); it.hasNext();) {
			Turtle t = (Turtle) it.next();
            g.setColor(decodeColor(t.getColor()));
			TurtleView turtleView = new TurtleView(t);
			Polygon arrow = turtleView.getShape();
//			.draw(turtleView.getShape());
			g.fillPolygon(arrow);

			drawSegments(g, t.getListSegments());
//			t.drawTurtle(g);
		}
	}

	public void drawSegments(Graphics graph, ArrayList<Segment> listSegment)
	{
		listSegment.stream().forEach((Segment segment) -> drawSegment(graph, segment));
	}

	public void drawSegment(Graphics graph, Segment segment) {
		graph.drawLine(segment.getStart().getX(), segment.getStart().getY(), segment.getEnd().getX(), segment.getEnd().getY());
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
}
