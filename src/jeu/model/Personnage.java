package jeu.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import jeu.Parametre;

public abstract class Personnage {

	final IntegerProperty xProp,yProp;
	private IntegerProperty PvProperty;
	private Terrain terrain;
	private Environnement env;
	
	public Personnage(int x, int y, int pv, Terrain terrain, Environnement env) {
		this.xProp = (new SimpleIntegerProperty(x));
		this.yProp = new SimpleIntegerProperty(y);
		this.PvProperty = new SimpleIntegerProperty(pv) ;
		this.terrain = terrain;
		this.env=env;
	}
	
	//-------------------------------------------------------------------//

	//Methodes Abstract//
	public abstract void perdrePv();
	
	//public abstract void seDeplace(Parametre.DIRECTION d);
	
	public abstract void attaquer (Personnage p);
	
	//-------------------------------------------------------------------//
	
	public int clamp (int val1 , int min, int max) {  // Pour borner un chiffre entre 2 valeurs pour pas que l'image s'enleve
		int valeurClamp = val1;

		if(valeurClamp<min) 
			valeurClamp = min;
		else if(valeurClamp>max) 
			valeurClamp= max;
		return valeurClamp;
	}
	
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
		
	
	public Terrain getTerrain() {
		return terrain;
	}
	
	public Environnement getEnv() {
		return env;
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