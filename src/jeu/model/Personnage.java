package jeu.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import jeu.Parametre;

public abstract class Personnage {


	private IntegerProperty CoordonneeXProperty,CoordonneeYProperty;
	private int vitesse;
	private IntegerProperty PvProperty;
	private Terrain terrain;
	
	
	
	public Personnage(int x, int y, int vitesse, int pv, Terrain terrain) {
		this.setxProp(new SimpleIntegerProperty(x));
		this.CoordonneeYProperty = new SimpleIntegerProperty(y);
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

	public final IntegerProperty CoordonneeXProperty() {
		return CoordonneeXProperty;
	}
	
	public final IntegerProperty CoordonneeYProperty() {
		return CoordonneeYProperty;
	}
	
	public IntegerProperty getX() {  // changer mettre bonne syntaxe
		return CoordonneeXProperty();
	}
	
	public int getVitesse() {
		return vitesse;
	}
	
	public Terrain getTerrain() {
		return terrain;
	}

	
	//-------------------------------------------------------------------//
	//Setters
	
	public void setxProp(IntegerProperty xProp) {
		this.CoordonneeXProperty = xProp;
	}
	
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	public void setPv(IntegerProperty pv) {
		this.PvProperty = pv;
	}
}
