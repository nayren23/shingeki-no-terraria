package jeu.model.inventaire.ressource;

import jeu.model.inventaire.Objet;

public class Ressource extends Objet{

	private int nbMax;
	private int nbRessource;
	private int resistance;//vie de la ressource

	public Ressource (int res, int id) {
		super(id);
		this.nbMax=200;
		this.nbRessource=1;
		this.resistance=res;
	}

	public int getResistance() {
		return resistance;
	}

	public int getNbMax() {
		return nbMax;
	}

	public int getNbRessource() {
		return nbRessource;
	}

	public void setNbRessource(int nbRessource) {
		this.nbRessource = nbRessource;
	}

	public void incrementerRessource() {
		this.nbRessource ++;
	}

	@Override
	public String toString() {
		return "nbRessource=" + nbRessource ;
	}
	
	

}
