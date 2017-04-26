package fr.polytech.turtle.view;// package logo;

import fr.polytech.turtle.model.Turtle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Titre :        Logo
 * Description :  Un exemple de programme graphique utilisant la celebre Turtle Logo
 * Copyright :    Copyright (c) 2000
 * Societe :      LIRMM
 * @author J. Ferber
 * @version 2.0
 */

public class FeuilleDessin extends JPanel {
	private List<Turtle> turtles; // la liste des turtles enregistrees
	
	public FeuilleDessin() {
		turtles = new ArrayList<Turtle>();
	}

	public void addTortue(Turtle o) {
		turtles.add(o);
	}

	public void reset() {
		for (Iterator it = turtles.iterator(); it.hasNext();) {
			Turtle t = (Turtle) it.next();
			t.reset();
		}
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
		for(Iterator it = turtles.iterator(); it.hasNext();) {
			Turtle t = (Turtle) it.next();
			t.drawTurtle(g);
		}
	}
}
