package jeu.model;

import jeu.Parametre;
import jeu.Parametre.DIRECTION;
import jeu.model.inventaire.Inventaire;
import jeu.model.inventaire.Objet;
import jeu.model.inventaire.arme.Hand;
import jeu.model.inventaire.ressource.Pain;

public class Heros extends Personnage{

	private Inventaire inventaireHeros;
	private Objet objetHeros;
	private Hand mainHeros;
	private int directionActuelle;

	//changer le type terrain en type environnement
	public Heros(int x, int y, Terrain terrain, Environnement env) {
		super(x, y, 9, env);
		this.mainHeros = new Hand();
		this.objetHeros= mainHeros;
		this.inventaireHeros = new Inventaire(super.getEnv());
		this.directionActuelle = 0;
	}


	//------------------------------------------------------------//


	public void gravite() {
		setY(getY()  + Parametre.forceGravite);
	}


	public boolean estMort () {
		boolean mort = false;
		if (this.PvProperty().getValue()<=0)
			mort = true;
		return mort;
	}

	//------------------------------------------------------------//

	/**
	 * // Pour borner un chiffre entre 2 valeurs pour pas que l'image du coeur s'enleve aisni ne pas 
	 * ainsi ne pas avoir + de 9 pv et - de 0 pv
	 * @param val1  notre pv actuelle
	 * @param min valeur la plus basse a ne jamais d�passer
	 * @param max valeur la plus haute a ne jamais d�passer
	 * @return  notre valeur comprise entre 0 et 9
	 */
	//	private int clamp (int val1 , int min, int max) {  // Pour borner un chiffre entre 2 valeurs pour pas que l'image s'enleve
	//		int valeurClamp = val1;
	//
	//		if(valeurClamp<min) 
	//			valeurClamp = min;
	//		else if(valeurClamp>max) 
	//			valeurClamp= max;
	//		return valeurClamp;
	//	}

	//------------------------------------------------------------//

	/**
	 * on ne peut pas etre en dessous de 0 pv g�rer grace au clamp
	 */
	public void perdrePv() { // en option mettre le nb de pv perdu en param�tre
		int pv = clamp(this.PvProperty().getValue()-1, 0, 9); // on prend notre valeur et on fait -1 et doit etre comprise entre 0 et 9
		this.PvProperty().setValue(pv);  // -1 pour le heros 
	}

	//------------------------------------------------------------//

	
	/**
	 * on ne peut pas etre en dessus de 9 pv g�rer grace au clamp
	 */
	public void augmenterPv(Pain pain) { // on prend notre valeur et on fait +1 et doit etre comprise entre 0 et 9
		int pv;
		if(this.inventaireHeros.verifierRessource(pain)) {
			pv = clamp(this.PvProperty().getValue()+1, 0, 9);	
			this.PvProperty().setValue(pv);  // -1 pour le heros 
		}
	}

	//------------------------------------------------------------//

	/**
	 * 
	 * @param numeroTuilesCasser que l on veut casser
	 * @param terrain sur quel terrain l'action doit se faire
	 */
	//	public void casserBloc (int numeroTuilesCasser, Terrain terrain) {  // ensuite rajouter l'objet miner dans l'inventaire 
	//		System.out.println("casser tuile : " + numeroTuilesCasser);
	//		terrain.changerTuiles(numeroTuilesCasser,Parametre.changementDuBlocCasser); //changer le 1 en bloc choisit
	//		System.out.println("C'est cassee Yes");			
	//	}

	public void equiper (Objet o) {
		setObjetHeros(o);
		System.out.println("Objet " +o.getIdObjet());
	}

	public Objet getObjetHeros() {
		return this.objetHeros;
	}

	//Getters et Setter



	public Inventaire getInventaireHeros() {
		return inventaireHeros;
	}



	public void setObjetHeros(Objet objetHeros) {
		this.objetHeros = objetHeros;
	}


	public int getDirectionActuelle() {
		return directionActuelle;
	}


	public void setDirectionActuelle(int directionActuelle) {
		this.directionActuelle = directionActuelle;
	}




}





