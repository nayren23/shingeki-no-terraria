package jeu.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import jeu.Parametre;

public  class Personnage {

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
		this.space = false;
	}

	//-------------------------------------------------------------------//

	public int clamp (int val1 , int min, int max) {  // Pour borner un chiffre entre 2 valeurs pour pas que l'image s'enleve
		int valeurClamp = val1;

		if(valeurClamp<min) 
			valeurClamp = min;
		else if(valeurClamp>max) 
			valeurClamp= max;
		return valeurClamp;
	}
	
	
	public void gravite() {
		setY(getY()  + Parametre.forceGravite);
	}
	
	public void collisions () {
		int x = this.xProp.get();
		int y = this.yProp.get();

		collisionDeDroite(x,y);
		collisionDeGauche(x,y);
		collisionDuHaut(x,y);
		collisionDuBas(x,y);
	}

	public void move () {
		this.xProp.set(xProp.get() + direction);
		this.yProp.set(yProp.get() + dirY);
	}



	public void sauter() {
		if (this.collisionDuBas( getX(), getY())) {
			additionnerDirY(-Parametre.hauteurSautPersonnage);
		}
	}



	public static int coordoonneTuile (int x,int y) {
		x = x / Parametre.tailleTuile;

		if (y > 0) {
			y = y / Parametre.tailleTuile;
		}
		else {
			y = -1;
		}

		return (x+(y+1)*Parametre.longueurTerrain);
	}
	
	public void additionnerDirY(int nb) {
		this.dirY += nb;
	}

	//permet de verifier la collision du haut avec le personnage en prenant le x du personnage et le y
	//verification avec la collision sur le bloc du haut soit y - la difference avec le bloc du haut et met donc la direction du Y a 0 si il y a collision
	public void collisionDuHaut (int x,int y) {
		if (verificationDeCollisions(coordoonneTuile(x + 17, y - Parametre.diffBlocDessu )) || verificationDeCollisions(coordoonneTuile(x + 17, y - Parametre.diffBlocDessu))) {
			this.setDirY(0);
		}
	}


	//permet de verifier la collision du bas avec le personnage en prenant le x du personnage et le y
	//Verification avec de pixel en y  avec ici y et y + 1
	public boolean collisionDuBas (int x,int y) {
		if (verificationDeCollisions(coordoonneTuile(x + 12 ,y+1)) || verificationDeCollisions(coordoonneTuile(x + 12, y+1))) {
			if (verificationDeCollisions(coordoonneTuile(x + 12 ,y)) || verificationDeCollisions(coordoonneTuile(x + 12, y))) {
				this.yProp.set(this.yProp.get() - Parametre.forceGravite);

			}
			if (this.getDirY() > 0  || this.getDirY()==-1) {
				this.setDirY(0);
				
			}
			return true;
		}
		else {
			return false;
		}
	}


	public boolean collisionDeDroite (int x,int y) {
			boolean bloque = false;
		if (verificationDeCollisions(coordoonneTuile(x + Parametre.largeurPersonnage, y - Parametre.hauteurPersonnage)) || verificationDeCollisions(coordoonneTuile(x + Parametre.largeurPersonnage, y - 1))) {
			this.xProp.set(x - this.direction);
			bloque = true;
		}
		if (verificationDeCollisions(coordoonneTuile(x + Parametre.largeurPersonnage, y - Parametre.hauteurPersonnage)) || verificationDeCollisions(coordoonneTuile(x +  Parametre.largeurPersonnage, y - 1))) {
			this.xProp.set(this.xProp.get() - 1);
			bloque= true;

		}
		return bloque;
		
	}


	public boolean collisionDeGauche (int x,int y) {
		boolean bloque = false;

		if (verificationDeCollisions(coordoonneTuile(x + 9, y - Parametre.hauteurPersonnage)) || verificationDeCollisions(coordoonneTuile(x + 9, y -1))) {
			this.xProp.set(x - this.direction);
			bloque = true;
		}
		if (verificationDeCollisions(coordoonneTuile(x + 9, y - Parametre.hauteurPersonnage)) || verificationDeCollisions(coordoonneTuile(x + 9, y-1))) {
			this.xProp.set(this.xProp.get() + 1);
			bloque= true;
		}
		return bloque;
	}



	private boolean verificationDeCollisions (int x) {
		return (x < 0 || getEnv().getTerrain().getTabTerrain()[x] > 0);
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