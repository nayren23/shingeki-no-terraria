package jeu.model.inventaire.arme;

import java.util.ArrayList;
import jeu.Parametre;
import jeu.model.Terrain;

public class Pelle extends Arme{

	private int id;
	private ArrayList<Integer> blocMinables;

	public Pelle () {
		super(3);
		this.blocMinables = new ArrayList<>();
		listeBlocMinables();
	}

	public void creuser (int numeroTuilesCasser, Terrain terrain) {  // ensuite rajouter l'objet miner dans l'inventaire 
		if(this.blocMinables.contains(terrain.getTerrain()[numeroTuilesCasser])) {
			terrain.affichertableau(terrain);
			terrain.getTerrain()[numeroTuilesCasser]=Parametre.changementDuBlocCasserPelle; // 0 = le ciel
			System.out.println("\n");
			terrain.affichertableau(terrain);
		}
	}
	
	private void listeBlocMinables () {
		this.blocMinables.add(1);	
		this.blocMinables.add(2);
		this.blocMinables.add(3);
		this.blocMinables.add(4);
	}

}
