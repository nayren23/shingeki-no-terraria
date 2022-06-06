package jeu.model;

import jeu.Parametre;
import jeu.Parametre.DIRECTION;
import jeu.model.inventaire.arme.Arme;
import jeu.model.inventaire.arme.Epee;

public  class PnjMechantTitan extends Personnage {

	int direction, dirY;
	//private HitBox hitboxTitans;

	public PnjMechantTitan(int x ,int y, Terrain terrain, Environnement env) {
		super(x, y, 100, terrain, env); // 100 pv
		//	this.hitboxTitans = new HitBox(x, y, 2, 3, 1, 4);
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

	public void sauter() {
		this.yProp.set(yProp.get() + dirY);
	}



	public void move () {
		if(yProp.get() > 355) {
			//            System.out.println(yProp);
			this.xProp.set(xProp.get() + direction);
			sauter();
		}

	}

    public void gravite() {
        if(getY() <= 395 ) {
            setY(getY()  + 2);

        }
    }

	public void seDeplace() {

		int coordonneErenX =getEnv().getEren().getX();
		int coordonneErenY =getEnv().getEren().getY();
		int porteeCoup = 2;
		//int porteeCoup2 = 3;


		int vitesse =2;
				System.out.println("\n Coordonne Titan X " + getX());
				System.out.println("\n Coordonne Titan YU " + getY());
		
				System.out.println("\n Coordonne Eren X " + coordonneErenX);
				System.out.println("\n Coordonne Eren Y " + coordonneErenY);

		if( (getX() -porteeCoup) <=coordonneErenX && (getX() +porteeCoup) >=coordonneErenX 
				&&  (getY() -porteeCoup) <=coordonneErenY && (getY() +porteeCoup) >=coordonneErenY
				) {
			attaquer(getEnv().getEren());

		}

		else {
			if (getX()!= coordonneErenX) {

				if(getX()> coordonneErenX) 
					setX(getX()-vitesse);

				else   
					setX(getX()+vitesse);
			}

			else if(getY()!=coordonneErenY) {

				if (getY() >coordonneErenY)
					setY(getY()-vitesse);

				else  
					setY(getY()+vitesse);
			}
		}

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

		System.out.println("\n jsui dna sle if");
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

