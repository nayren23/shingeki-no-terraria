package jeu.model.inventaire.ressource;

import java.util.Map;

import jeu.model.inventaire.Objet;

public class Ressource extends Objet{

	private int nbMax;
	private int nbRessource;
	private int resistance;//vie de la ressource

	public Ressource (int res, int id) {
		super(id);
		this.nbMax=50;
		this.nbRessource=1;
		this.resistance=res;
	}

	//une ressource peut avoir jusqu'à 50 d'elle même dans le meme emplacement de l'inventaire
	public void stackRessource (Objet o){
		for (int i=0; i<super.inventaire.size(); i++) {
			if (super.inventaire.get(i)==o)
				if (this.nbRessource<this.nbMax)
					this.nbRessource+=1;
				else
					ajouterDansInventaire(o);
		}
	}
	
	public void detruireBloc(int id) {
		
		switch (id) {
		case 0:
			//methode a mettre pour l'epee
			break;
		case 1:
			//methode a mettre pour la pioche
			break;
		case 2:
			//methode a mettre pour la hache
			break;
		case 3:
			//methode a mettre pour la pelle 
			break;
		}
	}

}
