package jeu.model.inventaire.arme;

import java.util.ArrayList;

import jeu.Parametre;
import jeu.model.Environnement;
import jeu.model.Terrain;
import jeu.model.inventaire.ressource.Terre;

public class Pioche extends Arme{
	
	private int id;
	private ArrayList<Integer> blocMinables;
	private Terre terre;
	private Environnement env;
	
	public Pioche () {
		super(1);
		this.blocMinables = new ArrayList<>();
		listeBlocMinables();
		this.terre = new Terre();
		this.env = new Environnement();
	}

	public void creuser (int numeroTuilesCasser, Terrain terrain) {  // ensuite rajouter l'objet miner dans l'inventaire 
		//souci au niveau de la condition car supprime le bloc visuellement 1 tour de trop apres
		if(this.blocMinables.contains(terrain.getTerrain()[numeroTuilesCasser] ) && env.getRessources().get(numeroTuilesCasser).getResistance()<=0/*getResistance()<=0*/) {
			terrain.getTerrain()[numeroTuilesCasser]=Parametre.changementDuBlocCasserPelle; // 0 = le ciel
		}
		else {
			env.getRessources().get(numeroTuilesCasser).enleverResistance(env.getRessources().get(numeroTuilesCasser));
		}
	}
	
	private void listeBlocMinables () {
		this.blocMinables.add(3);	//Bloc d herbe
		this.blocMinables.add(4);	//Bloc de Terre
		this.blocMinables.add(5);	//Bloc de Terre

	}

}
