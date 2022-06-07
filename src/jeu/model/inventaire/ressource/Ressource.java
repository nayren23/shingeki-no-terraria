package jeu.model.inventaire.ressource;

import jeu.Parametre;
import jeu.model.Terrain;
import jeu.model.inventaire.Objet;

public class Ressource extends Objet{

	private int nbRessource;
	private String nomRessource;
	private int resistance;//vie de la ressource

	public Ressource (int res, int id, String nom) {
		super(id);
		this.nbRessource=1;
		this.resistance=res;
		this.nomRessource=nom;
	}
	
	public void incrementerRessource() {
		this.nbRessource ++;
	}
	
	public void poserBloc (int numeroTuilesCasser, Terrain terrain , int blocAPoser) {  // ensuite rajouter l'objet miner dans l'inventaire 
		//rajouter condition pour pas build au meme endroit
		if(terrain.getTabTerrain()[numeroTuilesCasser] ==0)     {
			terrain.getTabTerrain()[numeroTuilesCasser]=blocAPoser; // 0 = le ciel
		}
	}
	
	public void enleverResistance(Ressource r) {
		this.resistance=r.getResistance()-1;
	}

	public int getResistance() {
		return resistance;
	}

	public int getNbRessource() {
		return nbRessource;
	}

	public void setNbRessource(int nbRessource) {
		this.nbRessource = nbRessource;
	}

	@Override
	public String toString() {
		return "Nom de la ressource = " + this.nomRessource + " nbRessource=" + nbRessource;
	}
	
}
