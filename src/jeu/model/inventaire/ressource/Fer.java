package jeu.model.inventaire.ressource;

import jeu.Parametre;
import jeu.model.Terrain;

public class Fer extends Ressource{

	public Fer() {
		super(5, 7);

	
		
	}
	public void poserBloc (int numeroTuilesCasser, Terrain terrain) {  // ensuite rajouter l'objet miner dans l'inventaire 
		//rajouter condition pour pas build au meme endroit
		if(terrain.getTerrain()[numeroTuilesCasser] ==0)     {
			terrain.getTerrain()[numeroTuilesCasser]=Parametre.blocFer; // 0 = le ciel
		}
	}

}
