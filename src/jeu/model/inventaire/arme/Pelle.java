package jeu.model.inventaire.arme;

import java.util.ArrayList;
import jeu.Parametre;
import jeu.model.Environnement;
import jeu.model.Terrain;
import jeu.model.inventaire.Objet;
import jeu.model.inventaire.ressource.Ressource;
import jeu.model.inventaire.ressource.Terre;

public class Pelle extends Arme{

	private int id;
	private ArrayList<Integer> blocMinables;
	private Terre terre;
	private Environnement env;
	
	public Pelle () {
		super(3);
		this.blocMinables = new ArrayList<>();
		listeBlocMinables();
		this.terre = new Terre();
		this.env = new Environnement();
		
	}

	public void creuser (int numeroTuilesCasser, Terrain terrain) {  // ensuite rajouter l'objet miner dans l'inventaire 
		if(this.blocMinables.contains(terrain.getTerrain()[numeroTuilesCasser] ) && env.getRessources().get(numeroTuilesCasser).getResistance()<=0/*getResistance()<=0*/) {
			terrain.getTerrain()[numeroTuilesCasser]=Parametre.changementDuBlocCasserPelle; // 0 = le ciel
		}
		else {
			env.getRessources().get(numeroTuilesCasser).enleverResistance(env.getRessources().get(numeroTuilesCasser));
		}
	}
	
	private void listeBlocMinables () {
		this.blocMinables.add(1);	
		this.blocMinables.add(2);
		this.blocMinables.add(3);
		this.blocMinables.add(4);
	}

}
