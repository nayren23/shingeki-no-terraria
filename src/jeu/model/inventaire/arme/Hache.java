package jeu.model.inventaire.arme;

import java.util.ArrayList;
import jeu.Parametre;
import jeu.model.Terrain;

public class Hache extends Arme{
	
	private int id;
	private ArrayList<Integer> blocMinables;
	
	public Hache () {
		super(2);
		this.blocMinables = new ArrayList<>();
	}
	
	public void creuser (int numeroTuilesCasser, Terrain terrain) {  // ensuite rajouter l'objet miner dans l'inventaire 
		if(this.blocMinables.contains(terrain.getTerrain()[numeroTuilesCasser]) ) {
			terrain.affichertableau(terrain);
			terrain.getTerrain()[numeroTuilesCasser]=Parametre.changementDuBlocCasserHache; // 0 = le ciel
			System.out.println("\n");
			terrain.affichertableau(terrain);
		}
	}
	
	private void listeBlocMinables () {
		//this.blocMinables.add(); a définir en fonction de la valeur du bloc dans le terrain
	}

}
