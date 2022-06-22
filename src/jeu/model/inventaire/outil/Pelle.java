package jeu.model.inventaire.outil;

import jeu.Parametre;
import jeu.model.Environnement;
import jeu.model.inventaire.ressource.Ciel;


public class Pelle extends Outil{


	public Pelle (Environnement env) {
		super(3, "pelle",env);
	}

	@Override
	public int enleverResistanceBloc(int numeroTuilesCasser) {
		int indiceBloc = -1;

		if ((getEnv().getObjet(numeroTuilesCasser).getIdObjet() !=3 ||
				getEnv().getObjet(numeroTuilesCasser).getIdObjet() !=4 ||
				getEnv().getObjet(numeroTuilesCasser).getIdObjet() !=5) 
			&& getEnv().getObjet(numeroTuilesCasser).getResistance()<=0){
			
			if(getEnv().getTerrain().getTabTerrain()[numeroTuilesCasser]==1) {
				getEnv().getTerrain().getTabTerrain()[numeroTuilesCasser] = Parametre.changementDuBlocCasser;
				indiceBloc = 1;
			}
			
			else if(getEnv().getTerrain().getTabTerrain()[numeroTuilesCasser]==2) {
				indiceBloc = 2;
				getEnv().getTerrain().getTabTerrain()[numeroTuilesCasser] = Parametre.changementDuBlocCasser;

			}
			getEnv().getRessources().set(numeroTuilesCasser, new Ciel());  // on change la terre par le ciel dans la liste des ressources

		}
		
		return indiceBloc;
	}

}
