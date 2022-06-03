package jeu.model.inventaire.outil;

import java.util.ArrayList;
import jeu.Parametre;
import jeu.model.Environnement;
import jeu.model.Terrain;
import jeu.model.inventaire.arme.Arme;
import jeu.model.inventaire.ressource.Ressource;
import jeu.model.inventaire.ressource.Terre;

public class Pelle extends Outil{


	public Pelle (Environnement env) {
		super(3, "pelle",env);
	}

	@Override
	public int enleverResistanceBloc(int numeroTuilesCasser) {
		int indiceBloc = -1;
		
		if (getEnv().getObjet(numeroTuilesCasser).getIdObjet() !=3 || getEnv().getObjet(numeroTuilesCasser).getIdObjet() !=4 || getEnv().getObjet(numeroTuilesCasser).getIdObjet() !=5) {
			if(getEnv().getTerrain().getTabTerrain()[numeroTuilesCasser]==1) {
				getEnv().getTerrain().getTabTerrain()[numeroTuilesCasser] = Parametre.changementDuBlocCasser;
				indiceBloc = 1;
			}
			
			else if(getEnv().getTerrain().getTabTerrain()[numeroTuilesCasser]==2) {
				indiceBloc = 2;
				getEnv().getTerrain().getTabTerrain()[numeroTuilesCasser] = Parametre.changementDuBlocCasser;
			}
		}
		
		return indiceBloc;
	}

}


//	public void creuser (int numeroTuilesCasser, Terrain terrain) {  // ensuite rajouter l'objet miner dans l'inventaire 
//		//souci au niveau de la condition car supprime le bloc visuellement 1 tour de trop apres
//		if(this.blocMinables.contains(terrain.getTerrain()[numeroTuilesCasser] ) /*&& env.getRessources().get(numeroTuilesCasser).getResistance()<=0*/) {
//			Ressource o= env.getRessources().get(numeroTuilesCasser);
//
//			terrain.getTerrain()[numeroTuilesCasser]=Parametre.changementDuBlocCasserPelle; // 0 = le ciel
//			this.env.getEren().getInventaireHeros().stackRessource();
//		}
//		else {
//			env.enleverResistance(env.getRessources().get(numeroTuilesCasser));
//		}
//		
//	}

