package jeu.model;

import jeu.Parametre;
import jeu.Parametre.DIRECTION;
import jeu.model.inventaire.arme.Arme;
import jeu.model.inventaire.arme.Epee;

public  class PnjMechantTitan extends Personnage {

	int direction, dirY;


	public PnjMechantTitan(int x ,int y, Terrain terrain, Environnement env) {
		super(x, y, 100, terrain, env); // 100 pv
	}

	/**
	 * 
	 * @param arme avec laquelle on afflige des degat au titans
	 * en fonction de l'arme on inflige plus ou moins de degat
	 */
	public void perdrePv(Arme arme) {
		int pv = clamp(this.PvProperty().getValue()-arme.getDegats(), 0, 100); // on prend notre valeur et on fait -1 et doit etre comprise entre 0 et 9
		this.PvProperty().setValue(pv); 		
	}

	public void seDeplace() {

		int coordonneErenX =getEnv().getEren().getX();
		int coordonneErenY =getEnv().getEren().getY();
		
		System.out.println("\n Coordonnee Eren X :" + coordonneErenX);
		System.out.println("\n Coordonnee Eren Y :" + coordonneErenY);

		System.out.println("\n Coordonnee Titan :" + getX());
		System.out.println("\n Coordonnee titan :" + getY());

		int vitesse =1;

		if (getX()!= coordonneErenX  ) {

			if(getX()> coordonneErenX) 
				setX(getX()-vitesse);
			
			else   
				setX(getX()+vitesse);
		}

		else if(getY() !=coordonneErenY) {

			 if (getY() >coordonneErenY)
				setY(getY()-vitesse);
			
			else  
				setY(getY()+vitesse);
			}

	else 
		attaquer(getEnv().getEren());

	}

	public boolean verificationMort () {
		boolean mort = false;
		if(getPvProperty().getValue() >0) {
			seDeplace();
		}
		else {
			//	System.out.println("\n Est mort");
			mort = true;
		}
		return mort;
	}

	@Override
	public void attaquer(Personnage p) {

		//			System.out.println("\n jsui dna sle if");
		getEnv().getEren().perdrePv();
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


	public int getDirection() {
		return direction;
	}

}

