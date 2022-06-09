package jeu.model;

import jeu.Parametre;
import jeu.Parametre.DIRECTION;
import jeu.model.inventaire.arme.Arme;
import jeu.model.inventaire.arme.Epee;

public  class PnjMechantTitan extends Personnage {

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



		//int dee=(int)(Math.random()* 2 +1);
		//		System.out.println("\n affichage du dee" +dee);
		System.out.println("\n affichage X titan" + getX());
		System.out.println("\n affichage y titan" + getY());

		//		int dee=(int)(Math.random()* 3 +1); // vitesse aléatoire entre 1,2,3

		if( (getX() -2)<=Parametre.coordonneeMinTerrainTitanGauche  ) { // on le fait allez jusqu a gauche puis
			setDirection(0);  //droite
		}

		else if((getX() +2)>=Parametre.coordonneeMaxTerrainTitanDroite) {
			setDirection(2); //gauche
		}

		if(getDirection() == 0) {
//			setX(getX()+2);
		}

		else
			setX(getX()-2);

		System.out.println("\n Affichage direction" + getDirection());

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

		// si coordonne titans a 50 de pres <= coordonneErenX
		if( (getX() -Parametre.porteeCoupDuTitanX) <=coordonneErenX && (getX() +Parametre.porteeCoupDuTitanX) >=coordonneErenX 
				&&  (getY() -Parametre.porteeCoupDuTitanY) <=coordonneErenY && (getY() +Parametre.porteeCoupDuTitanY) >=coordonneErenY
				) {
			erenPresent = true;		
			System.out.println("\n on a trouvé");
		

		if (getX()!= coordonneErenX  ) {

			if(getX()> coordonneErenX) 
				setX(getX()-Parametre.vitesseTitan);

			else   
				setX(getX()+Parametre.vitesseTitan);
		System.out.println("\n je cherche");

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





	@Override
	public String toString() {
		return "PnjMechantTitan [direction=" + getDirection() + ", dirY=" + getDirY() + ", nom=" + nom + "]";
	}

}
