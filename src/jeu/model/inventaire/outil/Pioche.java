package jeu.model.inventaire.outil;

import jeu.Parametre;
import jeu.model.Environnement;
import jeu.model.inventaire.ressource.Ciel;


public class Pioche extends Outil{

	public Pioche (Environnement env) {
		super(4, "pioche", env);
	}

	@Override
	public int enleverResistanceBloc(int numeroTuilesCasser) {
		int indiceBloc = -1;

		if ((getEnv().getObjet(numeroTuilesCasser).getIdObjet() ==3 || getEnv().getObjet(numeroTuilesCasser).getIdObjet() !=4 || getEnv().getObjet(numeroTuilesCasser).getIdObjet() ==5 )&& getEnv().getObjet(numeroTuilesCasser).getResistance()<=0){

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
			getEnv().getRessources().set(numeroTuilesCasser, new Ciel());  // on change la terre par le ciel dans la liste des ressources

		}
		return indiceBloc;
	}
}

