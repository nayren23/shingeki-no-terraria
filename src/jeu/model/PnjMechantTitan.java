package jeu.model;

import jeu.Parametre;
import jeu.Parametre.DIRECTION;

public  class PnjMechantTitan extends Personnage {


	int direction, dirY;

	public PnjMechantTitan(int x, int y,  Terrain terrain, Environnement env) {
		super(x, y, 100, terrain, env);
	}

	@Override
	public void perdrePv() {
		int pv = clamp(this.PvProperty().getValue()-1, 0, 9); // on prend notre valeur et on fait -1 et doit etre comprise entre 0 et 9
		this.PvProperty().setValue(pv);  // -1 pour le heros 		
	}


	public void seDeplace( int xHero ,  int yHero) {
			while (getX() != xHero ) {
				setDirection(-5);
			}

			while (getX() != xHero ) {
				setDirection(5);
			}		


	}


	@Override
	public void attaquer(Personnage p) {
		// TODO Auto-generated method stub

	}

	public int setDirection(int i) {
		return this.direction = i;
	}

	public int getDirY() {
		return dirY;
	}

	public void setDirY(int dirY) {
		this.dirY = dirY;
	}


}

