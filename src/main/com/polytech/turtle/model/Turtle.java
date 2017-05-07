package main.com.polytech.turtle.model;// package logo;

import java.util.ArrayList;
import java.util.Observable;


/*************************************************************************

	Un petit Logo minimal qui devra etre ameliore par la suite

	Source originale : J. Ferber - 1999-2001

			   Cours de DESS TNI - Montpellier II

	@version 2.0
	@date 25/09/2001

**************************************************************************/


public class Turtle extends Observable
{

	public static final int rp=10, rb=5; // Taille de la pointe et de la base de la fleche

	// TODO FIX THIS
	public static final double ratioDegRad = 0.0174533; // Rapport radians/degres (pour la conversion)

	protected ArrayList<Segment> listSegments; // Trace de la fr.polytech.turtle
	
	protected int x;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	protected int y;

	public int getDir() {
		return dir;
	}

	public ArrayList<Segment> getListSegments() {
		return listSegments;
	}

	protected int dir;
	protected boolean crayon; 
	protected int coul;
	
	public void setColor(int n) {coul = n;}
	public int getColor() {return coul;}

	public Turtle() {
		listSegments = new ArrayList<Segment>();
		reset();
	}

	private void notifyView() {
		this.setChanged();
		this.notifyObservers();
	}

	public void reset() {
		x = 0;
		y = 0;
		dir = -90;
		coul = 0;
		crayon = true;
		listSegments.clear();
		notifyView();
  	}

	public void setPosition(int newX, int newY) {
		x = newX;
		y = newY;
		notifyView();
	}



	public void avancer(int dist) {
		int newX = (int) Math.round(x+dist*Math.cos(ratioDegRad*dir));
		int newY = (int) Math.round(y+dist*Math.sin(ratioDegRad*dir));
		
		if (crayon==true) {
			Segment seg = new Segment(coul, new Point(x ,y), new Point(newX, newY));
			listSegments.add(seg);
		}

		this.setPosition(newX, newY);
	}

	public void droite(int ang) {
		dir = (dir + ang) % 360;
	}

	public void gauche(int ang) {
		dir = (dir - ang) % 360;
	}

	public void baisserCrayon() {
		crayon = true;
	}

	public void leverCrayon() {
		crayon = false;
	}

	public void couleur(int n) {
		coul = n % 12;
	}

	public void couleurSuivante() {
	 	couleur(coul+1);
	}

	/** quelques classiques */

	public void carre() {
		for (int i=0;i<4;i++) {
			avancer(100);
			droite(90);
		}
	}

	public void poly(int n, int a) {
		for (int j=0;j<a;j++) {
			avancer(n);
			droite(360/a);
		}
	}

	public void spiral(int n, int k, int a) {
		for (int i = 0; i < k; i++) {
			couleur(coul+1);
			avancer(n);
			droite(360/a);
			n = n+1;
		}
	}
}
