package jeu.model;

import jeu.Parametre;
import jeu.model.inventaire.Inventaire;
import jeu.model.inventaire.Objet;
import jeu.model.inventaire.arme.Hand;

public class Heros extends Personnage{

	int direction, dirY;
	boolean space;
	private Inventaire inventaireHeros;
	private Objet objetHeros;
	private Hand mainHeros;
	//changer le type terrain en type environnement
	public Heros(int x, int y, Terrain terrain, Environnement env) {
		super(x, y,  9, terrain, env);
		this.mainHeros = new Hand();
		this.objetHeros= mainHeros;
		this.inventaireHeros = new Inventaire(super.getEnv());
	}

	//------------------------------------------------------------//

	public void seDeplace(Parametre.DIRECTION d) {
		switch(d) {
		case LEFT:
			setDirection(-5);
			break;

		case RIGHT:
			setDirection(5);
			break;

		case SPACE:
			dirY = -5;
			System.out.println(this.space);

			break;

		default:
			System.out.println("Entrée incorrecte");
			break;
		}
	}
	
	@Override
	public void attaquer(Personnage p) {
		// TODO Auto-generated method stub
		
	}

	//------------------------------------------------------------//
	public void move () {
		if(yProp.get() > 320) {
			System.out.println(yProp);
			System.out.println(getX()/30);
			System.out.println(getY()/28);
			this.xProp.set(xProp.get() + direction);
			if(space == true) {
				this.yProp.set(yProp.get() + dirY);

			}
			else {
				dirY = 0;
			}

		}

	}

	//------------------------------------------------------------//

	public void gravite() {
		if(getY() <= 360)  {

			if(getDirection() == -3) {
				setX(getX() - 2);
				setY(getY() + 2);
			}
			else if (getDirection() == 3){
				setY(getY() + 2);
				setX(getX() + 2);
			}
			else {
				setY(getY() + 2);

			}
		}
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

	@Override
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
	public void augmenterPv() { // on prend notre valeur et on fait +1 et doit etre comprise entre 0 et 9
		int pv = clamp(this.PvProperty().getValue()+1, 0, 9);	
		this.PvProperty().setValue(pv);  // -1 pour le heros 
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
		System.out.println("Objet  " +o.getIdObjet());
	}

	public Objet getObjetHeros() {
		return this.objetHeros;
	}

	//------------------------------------------------------------//

	//	public boolean estMort(int pv) { // a finir
	//			boolean estMort = false;
	//			
	//			if(pv==0) {
	//				estMort =true;
	//			}
	//			return estMort;
	//			
	//}



	//------------------------------------------------------------//

	//Getters et Setter

	public int getDirection() {
		return this.direction;
	}

	public Inventaire getInventaireHeros() {
		return inventaireHeros;
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

	public void setSpace(boolean space) {
		this.space = space;
	}
	public void setObjetHeros(Objet objetHeros) {
		this.objetHeros = objetHeros;
	}
	public boolean isSpace() {
		return space;
	}



}





