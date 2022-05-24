package jeu.model.inventaire;

import java.util.ArrayList;

public class Ressource extends Objet{
	
	private int nbMax;
	private int nbRessource;
	private String nomRessource;
	
	public Ressource(int id, ArrayList<Objet> o, int x, int y, String nom) {
		super(id, o, x, y);
		this.nbMax=32;
		this.nbRessource=1;
		this.nomRessource=nom;
	}
	
	//une ressource peut avoir jusqu'à 64 d'elle même dans le meme emplacement de l'inventaire
	public void stackRessource (Objet o){
		if (this.nbRessource<this.nbMax)
			this.nbRessource+=1;
		else
			ajouterDansInventaire(o);
	}

}
