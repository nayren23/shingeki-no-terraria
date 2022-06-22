package jeu.model.inventaire.ressource;


import jeu.model.Terrain;
import jeu.model.inventaire.Objet;

public class Ressource extends Objet{

	private int nbRessource;
	private int resistance;//vie de la ressource

	public Ressource (int res, int id, String nom) {
		super(id);
		this.nbRessource=1;
		this.resistance=res;
	}

	public void incrementerRessource() {
		this.nbRessource ++;
	}

	public void decrementerRessource(int quantite) {
		this.nbRessource -= quantite;
	}

	public boolean poserBloc (int numeroTuilesCasser, Terrain terrain , int blocAPoser) {  // ensuite rajouter l'objet miner dans l'inventaire 
		boolean peutPoser = false;
		if(terrain.getTabTerrain()[numeroTuilesCasser] ==0) {
			terrain.getTabTerrain()[numeroTuilesCasser]=blocAPoser; // 0 = le ciel
			peutPoser = true;
		}
		return peutPoser;
	}

	public void enleverResistance(Ressource r) {
		this.resistance=r.getResistance()-2;
	}

	
	
/////////////////////Getters///////////////////////

	public int getResistance() {
		return resistance;
	}

	public int getNbRessource() {
		return nbRessource;
	}

	
	
/////////////////////Setters///////////////////////

	public void setNbRessource(int nbRessource) {
		this.nbRessource = nbRessource;
	}

	@Override
	public String toString() {
		return "" + nbRessource;
	}

}
