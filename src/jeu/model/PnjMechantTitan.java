package jeu.model;

import jeu.Parametre;
import jeu.model.inventaire.arme.Arme;

public  class PnjMechantTitan extends Personnage {

	private String nom ;

	public PnjMechantTitan(int x ,int y,  Environnement env, String nom) {
		super(x, y, 100, env); // 100 pv
		this.nom = nom;
		setDirection(1); // on le fait d'abor allez a droite
		// -1 pour gauche 1 droite
	}

	/**
	 * @param arme avec laquelle on afflige des degat au titans
	 * en fonction de l'arme on inflige plus ou moins de degat
	 */
	public void perdrePv(Arme arme) {
		int pv = clamp(this.PvProperty().getValue()-arme.getDegats(), 0, 100); // on prend notre valeur et on fait -1 et doit etre comprise entre 0 et 9
		this.PvProperty().setValue(pv); 		
	}


	public void gravite() {
		setY(getY()  + Parametre.forceGravite);
	}

	/**
	 * Tant que le titan n a pas atteind sa limite aussi bien a gauceh que a droite on le fait avencer
	 * sinon s il a taper a droite ou a gauche on change sa direction 
	 */
	public void seDeplace() {


		if( collisionDeDroite(getX(), getY()) ) { // on le fait allez jusqu a gauche puis
			setDirection(-1);  //gauche
		}

		else if( collisionDeGauche(getX(), getY())) {
			setDirection(1); //droite
		}
		
	}

	/**
	 * si eren est a cote du titan alor le titan attauqe eren sinon juste il continue a se deplacer normalement
	 */
	public void attaquePnjDansZone () {

		if (erenDansZone() ==  true) {
			attaquer();
		}
		else 
			seDeplace();
	}

	/**
	 * si eren dans la zone du titan il l'attauqe sinon 
	 * @return si eren est dans la zone du titan
	 */
	public boolean erenDansZone () {

		boolean erenPresent = false;
		int coordonneErenX =getEnv().getEren().getX();
		int coordonneErenY =getEnv().getEren().getY();

		// si coordonne titans a 50 de pres <= coordonneErenX
		if( (getX() -Parametre.porteeCoupDuTitanX) <=coordonneErenX && (getX() +Parametre.porteeCoupDuTitanX) >=coordonneErenX 
				&&  (getY() -Parametre.porteeCoupDuTitanY) <=coordonneErenY && (getY() +Parametre.porteeCoupDuTitanY) >=coordonneErenY
				) {
			erenPresent = true;		
			//			System.out.println("\n on a trouvé");

			if (getX()!= coordonneErenX  ) {

				if(getX()> coordonneErenX) 
					setDirection(-1);
				else   
					setDirection(1);
			}
		}
		else 
			erenPresent = false;		
		return erenPresent;

	}


	/**
	 * Fonction qui verifie si le titan est mort alors il bouge plus et disparait aussi dans la vue
	 * sinon il appelle la fonction attaquerPNJ
	 * @return
	 */
	public boolean verificationMort () {
		boolean mort = false;
		if(PvProperty().getValue() >0) {
			attaquePnjDansZone();
		}
		else {
			mort = true;
		}
		return mort;
	}


	/**
	 * 
	 * Fonction qui met un cooldown au attaque du titans pour pas qu il attauqe en boucle eren
	 */
	public void attaquer() {
		if (Parametre.rechargeAttaqueTitans == Parametre.rechargeAttaqueTitansTemps) {
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
