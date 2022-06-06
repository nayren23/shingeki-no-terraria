package jeu.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import jeu.Parametre;

public abstract class Personnage {

	final IntegerProperty xProp,yProp;
	private int vitesse;
	private IntegerProperty PvProperty;
	private Terrain terrain;
	private Environnement env;
	private int direction, dirY;
	private boolean space;


	public Personnage(int x, int y, int pv, Environnement env) {
		this.xProp = (new SimpleIntegerProperty(x));
		this.yProp = new SimpleIntegerProperty(y);
		this.PvProperty = new SimpleIntegerProperty(pv) ;
		this.direction = 0;
		this.dirY = 0;
		this.env=env;
	}

	//-------------------------------------------------------------------//

	//Methodes Abstract//
	public abstract void perdrePv();

	public abstract void augmenterPv();


	public void collisions () {
		int x = this.xProp.get();
		int y = this.yProp.get();
		
		collisionDroite(x,y);
		collisionGauche(x,y);
		collisionHaut(x,y);
		collisionBas(x,y);
		


	}
	public void move () {
		this.xProp.set(xProp.get() + direction);
		sauter();


	}


	public void sauter() {
		if(space == true) {
			System.out.println("je saute");
			this.yProp.set(yProp.get() + getDirY());
		}
		else {
			setDirY(0);
		}

	}
	public static int coordoonneTuile (int x,int y) {
		if(x < 0 || y < -75){
			return -1;
		}
		else {
			x = x/Parametre.tailleTuile;
			if (y > 0) {
				y = y / Parametre.tailleTuile;
			}
			else {
				y = -1;
			}
			return (x+(y+1)*Parametre.longueurTerrain);
		}

	}






	public void collisionHaut (int x,int y) {
		if (verifCollisions(coordoonneTuile(x+17, y-32))||verifCollisions(coordoonneTuile(x+12, y-32))) {
			this.setDirY(0);
		}
	}


	public boolean collisionBas (int x,int y) {
		if (verifCollisions(coordoonneTuile(x+17 ,y+1))||verifCollisions(coordoonneTuile(x+12, y+1))) {
			if (verifCollisions(coordoonneTuile(x+17 ,y))||verifCollisions(coordoonneTuile(x+12, y))) {
				this.yProp.set(this.yProp.get() - Parametre.forceGravite);
			}
			if (this.getDirY()>0 || this.getDirY()==-1) {
				this.setDirY(0);
			}
			return true;
		}
		else {
			return false;
		}
	}


	public void collisionDroite (int x,int y) {
		if (verifCollisions(coordoonneTuile(x+20, y-25))||verifCollisions(coordoonneTuile(x+20, y-1))) {
			this.xProp.set(x-this.direction);
		}
	}

	
	public void collisionGauche (int x,int y) {
		if (verifCollisions(coordoonneTuile(x+10, y-25))||verifCollisions(coordoonneTuile(x+10, y-1))) {
			this.xProp.set(x+this.direction);
		}
	}


	private boolean verifCollisions (int x) {
		return (x < 0 || getEnv().getTerrain().getTabTerrain()[x]>0);
	}


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

	public Environnement getEnv() {
		return env;
	}

	public int getDirection() {
		return this.direction;
	}

	public int getDirY() {
		return dirY;
	}

	public boolean getSpace() {
		return space;
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

	public int setDirection(int i) {
		return this.direction= i;
	}


	public void setDirY(int dirY) {
		this.dirY = dirY;
	}

	public void setSpace(boolean space) {
		this.space = space;
	}
}