package jeu.model.inventaire.arme;

import java.util.ArrayList;

import jeu.Parametre;
import jeu.model.Environnement;
import jeu.model.Terrain;
import jeu.model.inventaire.ressource.Terre;

public class Pioche extends Arme{

	private int id;
	private ArrayList<Integer> blocMinables;
	private Environnement env;

	public Pioche (Environnement env) {
		super(4, "pioche");
		this.blocMinables = new ArrayList<>();
		listeBlocMinables();
		this.env = env;
	}

	public void creuser (int numeroTuilesCasser, Terrain terrain) {  // ensuite rajouter l'objet miner dans l'inventaire 
		//souci au niveau de la condition car supprime le bloc visuellement 1 tour de trop apres
		if(this.blocMinables.contains(terrain.getTerrain()[numeroTuilesCasser] ) /*&& env.getRessources().get(numeroTuilesCasser).getResistance()<=0/*getResistance()<=0*/) {
			terrain.getTerrain()[numeroTuilesCasser]=Parametre.changementDuBlocCasserPelle; // 0 = le ciel
			//this.env.getEren().getInventaireHeros().stackRessource(null);
		}
		else {
			env.enleverResistance(env.getRessources().get(numeroTuilesCasser));		}
	}

	private void listeBlocMinables () {
		this.blocMinables.add(3);	//Bloc d herbe
		this.blocMinables.add(4);	//Bloc de Terre
		this.blocMinables.add(5);	//Bloc de Terre

	}

}

