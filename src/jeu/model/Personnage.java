package jeu.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import jeu.Parametre;

public abstract class Personnage {

	final IntegerProperty xProp,yProp;
	private int vitesse;
	private IntegerProperty PvProperty;
	private Terrain terrain;
	
	public Personnage(int x, int y, int vitesse, int pv, Terrain terrain) {
		this.xProp = (new SimpleIntegerProperty(x));
		this.yProp = new SimpleIntegerProperty(y);
		this.vitesse = vitesse;
		this.PvProperty = new SimpleIntegerProperty(pv) ;
		this.terrain = terrain;
	}
	
	//-------------------------------------------------------------------//

	//Methodes Abstract//
	public abstract void perdrePv();
	
	public abstract void augmenterPv();

	public abstract void seDeplace(Parametre.DIRECTION d);
	
	//-------------------------------------------------------------------//
	
	//Getters
	public final IntegerProperty PvProperty() {
		return PvProperty;
	}

	public final int getX() {
		return this.xProp.getValue();
	}
	
	public final int getY() {
		return this.yProp.getValue();
	}

	public final IntegerProperty xProperty() {
		return this.xProp;
	}
	public final IntegerProperty yProperty() {
		return this.yProp;
	}
	

	
	public int getVitesse() {
		return vitesse;
	}
	
	public Terrain getTerrain() {
		return terrain;
	}

	//-------------------------------------------------------------------//
	//Setters
	
	public final void setX(double d) {
		this.xProp.setValue(d);
	}
	
	public final void setY(int val) {
		this.yProp.setValue(val);
	}
	
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	public void setPv(IntegerProperty pv) {
		this.PvProperty = pv;
	}
}