package jeu.model;

import jeu.Parametre;
import jeu.Parametre.DIRECTION;
import jeu.model.inventaire.arme.Arme;
import jeu.model.inventaire.arme.Epee;

public  class PnjMechantTitan extends Personnage {

	int direction, dirY;
	private String nom ;
	//private HitBox hitboxTitans;

	public PnjMechantTitan(int x ,int y,  Environnement env, String nom) {
		super(x, y, 100, env); // 100 pv
		this.	nom = nom;
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

	/**
	 * 
	 * @param coordooneeX
	 * @param coordonneeY
	 * @param coordonneeErenX
	 * @param coordonneeErenY
	 * @param porteeCoup
	 * @return
	 */
	public boolean hitbox(int coordooneeX ,int coordonneeY , int coordonneeErenX , int coordonneeErenY, int porteeCoup) {
		boolean estComprisDansIntervalle = false;

		if( (coordooneeX -porteeCoup) <=coordonneeErenX && (coordooneeX +porteeCoup) >=coordonneeErenX 
				&&  (coordonneeY -porteeCoup) <=coordonneeErenY && (coordonneeY +porteeCoup) >=coordonneeErenY) {
			estComprisDansIntervalle = true;
		}
		else {
			estComprisDansIntervalle = false;
		}
		return estComprisDansIntervalle;
	}

	public void seDeplace() {



		int coordonneeMinTerrain =320;
		int coordonneeMaxTerrain =1052;

		int dee=(int)(Math.random()* 6 +1);
		System.out.println("\n affichage du dee" +dee);
		System.out.println("\n affichage X titan" + getX());
		System.out.println("\n affichage y titan" + getY());

		if(coordonneeMinTerrain  <getX()  && getX()< coordonneeMaxTerrain ) {
			if(getX() < coordonneeMaxTerrain) {
				setX(getX() -2);  // on le fait allez jusqu a gauche puis 
//				if(getX() <= coordonneeMinTerrain) {
//					setX(getX() +2);  // on le fait allez jusqu a gauche puis 
//				}
			}
		}
		else 
			setX(1050); //on le remet tout a droite

	}

	public void attaquePnj () {

		if (erenDansZone() ==  true) {
			attaquer();
		}
		else 
			seDeplace();
	}

	public boolean erenDansZone () {

		boolean erenPresent = false;
		int coordonneErenX =getEnv().getEren().getX();
		int coordonneErenY =getEnv().getEren().getY();

		if( (getX() -Parametre.porteeCoupDuTitan) <=coordonneErenX && (getX() +Parametre.porteeCoupDuTitan) >=coordonneErenX 
				&&  (getY() -Parametre.porteeCoupDuTitan) <=coordonneErenY && (getY() +Parametre.porteeCoupDuTitan) >=coordonneErenY
				) {
			erenPresent = true;		



			if (getX()!= coordonneErenX  ) {

				if(getX()> coordonneErenX) 
					setX(getX()-Parametre.vitesseTitan);

				else   
					setX(getX()+Parametre.vitesseTitan);
			}
		}
		return erenPresent;

	}








	public boolean verificationMort () {
		boolean mort = false;
		if(PvProperty().getValue() >0) {
			attaquePnj();
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
			//			System.out.println("\n jsui dna sle if");
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

	@Override
	public String toString() {
		return "PnjMechantTitan [direction=" + direction + ", dirY=" + dirY + ", nom=" + nom + "]";
	}

}
