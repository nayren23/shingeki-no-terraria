package jeu.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import jeu.Parametre;

public abstract class Personnage {


	IntegerProperty xProp,yProp;
	private int vitesse;
	private int pv;
	private Terrain terrain;
	
	
	
	public Personnage(int x, int y, int vitesse, int pv, Terrain terrain) {
		this.xProp = new SimpleIntegerProperty(x);
		this.yProp = new SimpleIntegerProperty(y);
		this.vitesse = vitesse;
		this.pv = pv;
		this.terrain = terrain;
	}
	
	public abstract void seDeplace(Parametre.DIRECTION d);
	
	public IntegerProperty getX() {
		return xProp;
	}
	
	public IntegerProperty getY() {
		return yProp;
	}
	
	public int getVitesse() {
		return vitesse;
	}
	
	public int getPv() {
		return pv;
	}
	
}


