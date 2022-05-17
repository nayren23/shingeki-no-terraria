package jeu.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import jeu.Parametre;

public abstract class Personnage {


	private IntegerProperty xProp,yProp;
	private int vitesse;
	private IntegerProperty pv;
	private Terrain terrain;
	
	
	
	public Personnage(int x, int y, int vitesse, int pv, Terrain terrain) {
		this.setxProp(new SimpleIntegerProperty(x));
		this.yProp = new SimpleIntegerProperty(y);
		this.vitesse = vitesse;
		this.pv = new SimpleIntegerProperty(pv);
		this.terrain = terrain;
	}
	
	public Terrain getTerrain() {
		return terrain;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	public void setPv(IntegerProperty pv) {
		this.pv = pv;
	}
	
	public abstract void perdrePv();

	public abstract void seDeplace(Parametre.DIRECTION d);
	
	public IntegerProperty getX() {  // changer mettre bonne syntaxe
		return getxProp();
	}
	
	public IntegerProperty getY() {
		return yProp;
	}
	
	public int getVitesse() {
		return vitesse;
	}
	
	public IntegerProperty getPv() {
		return pv;
	}

	public IntegerProperty getxProp() {
		return xProp;
	}

	public void setxProp(IntegerProperty xProp) {
		this.xProp = xProp;
	}
	
}


