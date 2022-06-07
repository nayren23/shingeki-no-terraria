package jeu.model;

import jeu.Parametre;
import jeu.Parametre.DIRECTION;
import jeu.model.inventaire.arme.Arme;
import jeu.model.inventaire.arme.Epee;

public  class PnjMechantTitan extends Personnage {

	int direction, dirY;
	//private HitBox hitboxTitans;

	public PnjMechantTitan(int x ,int y,  Environnement env) {
		super(x, y, 100, env); // 100 pv
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

	//	public void sauter() {
	//		this.yProp.set(yProp.get() + dirY);
	//	}

	public void gravite() {
		setY(getY()  + Parametre.forceGravite);

	}


	public void seDeplace() {

		int coordonneErenX =getEnv().getEren().getX();
		int coordonneErenY =getEnv().getEren().getY();
		//				System.out.println("\n Coordonne Titan X " + getX());
		//				System.out.println("\n Coordonne Titan YU " + getY());
		//		
		//				System.out.println("\n Coordonne Eren X " + coordonneErenX);
		//				System.out.println("\n Coordonne Eren Y " + coordonneErenY);

		if( (getX() -Parametre.porteeCoupDuTitan) <=coordonneErenX && (getX() +Parametre.porteeCoupDuTitan) >=coordonneErenX 
				&&  (getY() -Parametre.porteeCoupDuTitan) <=coordonneErenY && (getY() +Parametre.porteeCoupDuTitan) >=coordonneErenY
				) {
			attaquer();

		}

		else {
			if (getX()!= coordonneErenX) {

				if(getX()> coordonneErenX) 
					setX(getX()-Parametre.vitesseTitan);

				else   
					setX(getX()+Parametre.vitesseTitan);
			}

			else if(getY()!=coordonneErenY) {

				if (getY() >coordonneErenY)
					setY(getY()-Parametre.vitesseTitan);

				else  
					setY(getY()+Parametre.vitesseTitan);
			}
		}

	}

	public boolean verificationMort () {
		boolean mort = false;
		if(PvProperty().getValue() >0) {
			seDeplace();
		}
		else {
			//	System.out.println("\n Est mort");
			mort = true;
		}
		return mort;
	}


	/**
	 * 
	 * 
	 */
	public void attaquer() {
		if (Parametre.rechargeAttaqueTitans == Parametre.rechargeAttaqueTitansTemps) {
			System.out.println("\n jsui dna sle if");
			getEnv().getEren().perdrePv();
			Parametre.rechargeAttaqueTitans =0;
		}
		else 
			Parametre.rechargeAttaqueTitans++;
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
