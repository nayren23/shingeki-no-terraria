package jeu.model.inventaire.outil;

import jeu.Parametre;
import jeu.model.Environnement;


public class Pioche extends Outil{

	public Pioche (Environnement env) {
		super(4, "pioche", env);
	}

	@Override
	public int enleverResistanceBloc(int numeroTuilesCasser) {
		int indiceBloc = -1;

		if(getEnv().getTerrain().getTabTerrain()[numeroTuilesCasser]==3 ) {
			indiceBloc = 3;
			getEnv().getTerrain().getTabTerrain()[numeroTuilesCasser] = Parametre.changementDuBlocCasser;
		}
			
		else if(getEnv().getTerrain().getTabTerrain()[numeroTuilesCasser]==4 ) {
			indiceBloc = 4;
			getEnv().getTerrain().getTabTerrain()[numeroTuilesCasser] = Parametre.changementDuBlocCasser;

		}
		else if (getEnv().getTerrain().getTabTerrain()[numeroTuilesCasser]==5) {
			indiceBloc = 5;
			getEnv().getTerrain().getTabTerrain()[numeroTuilesCasser] = Parametre.changementDuBlocCasser;
		}
		
		return indiceBloc;
	}
}



//	public void creuser (int numeroTuilesCasser, Terrain terrain) {  // ensuite rajouter l'objet miner dans l'inventaire 
//		System.out.println("\n Affichage liste"+env.getRessources());
//		//souci au niveau de la condition car supprime le bloc visuellement 1 tour de trop apres
//		if(this.blocMinables.contains(terrain.getTerrain()[numeroTuilesCasser] )) {
//			Ressource o= env.getRessources().get(numeroTuilesCasser);
//			System.out.println("\nAffichage de la ressource"+o);
//			this.env.getEren().getInventaireHeros().stackRessource(o);
//			terrain.getTerrain()[numeroTuilesCasser]=Parametre.changementDuBlocCasserPelle; // 0 = le ciel
//
//		}
//		else {
//			env.enleverResistance(env.getRessources().get(numeroTuilesCasser));		}
//	}

