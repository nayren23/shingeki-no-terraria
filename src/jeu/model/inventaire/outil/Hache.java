package jeu.model.inventaire.outil;

import jeu.Parametre;
import jeu.model.Environnement;
import jeu.model.inventaire.ressource.Ciel;


public class Hache extends Outil{

	public Hache (Environnement env) {
		super(1, "hache",env);
	}

	@Override
	public int enleverResistanceBloc(int numeroTuilesCasser) {
		int indiceBloc = -1;

		if ((getEnv().getObjet(numeroTuilesCasser).getIdObjet() == 5 && getEnv().getObjet(numeroTuilesCasser).getResistance()<=0)){
			System.out.println(getEnv().getObjet(numeroTuilesCasser).getIdObjet() );
			if(getEnv().getTerrain().getTabTerrain()[numeroTuilesCasser]==6) {
				getEnv().getTerrain().getTabTerrain()[numeroTuilesCasser] = Parametre.changementDuBlocCasser;
				indiceBloc = 6;
				System.out.println("premiere condition");
			}
			
			getEnv().getRessources().set(numeroTuilesCasser, new Ciel());  // on change la terre par le ciel dans la liste des ressources

		}
		return indiceBloc;
	}

}
