package jeu.model.inventaire.ressource;

import jeu.model.inventaire.Objet;

public class Ressource extends Objet{

	private int nbMax;
	private int nbRessource;
	private String nomRessource;
	private int resistance;//vie de la ressource

	public Ressource (int res, int id, String nom) {
		super(id);
		this.nbMax=200;
		this.nbRessource=1;
		this.resistance=res;
		this.nomRessource=nom;
	}
	
	public void incrementerRessource() {
		this.nbRessource ++;
	}
	
	public void enleverResistance(Ressource r) {
		this.resistance=r.getResistance()-1;
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

	@Override
	public String toString() {
		return "Nom de la ressource = " + this.nomRessource + " nbRessource=" + nbRessource;
	}
	
	

}
