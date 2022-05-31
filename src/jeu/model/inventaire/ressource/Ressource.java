package jeu.model.inventaire.ressource;

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
		for (int i=0; i<super.getInventaire().size(); i++) 
			if (super.getInventaire().get(i)==o) {
				if (this.nbRessource<this.nbMax)
					this.nbRessource+=1;
				else
					ajouterDansInventaire(o);
			}
	}

	public void enleverResistance (Objet o) {
		this.resistance-=2;
		if (this.resistance<=0) {
			System.out.println("vide");
			stackRessource(o);
			System.out.println(getInventaire());
		}

	}

	public int getResistance() {
		return resistance;
	}

	public void detruireBloc(int id) {
		super.getInventaire().remove(id);
	}


}
