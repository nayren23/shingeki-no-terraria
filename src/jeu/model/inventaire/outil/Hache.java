package jeu.model.inventaire.outil;

import jeu.Parametre;
import jeu.model.Environnement;


public class Hache extends Outil{

	public Hache (Environnement env) {
		super(1, "hache",env);
	}

	@Override
	public int enleverResistanceBloc(int numeroTuilesCasser) {
		int indiceBloc = -1;

		if(getEnv().getTerrain().getTabTerrain()[numeroTuilesCasser]==3 ) 
			indiceBloc = 3;

		else if(getEnv().getTerrain().getTabTerrain()[numeroTuilesCasser]==4 )
			indiceBloc = 4;

		else if (getEnv().getTerrain().getTabTerrain()[numeroTuilesCasser]==5)
			indiceBloc = 5;
		
		getEnv().getTerrain().getTabTerrain()[numeroTuilesCasser] = Parametre.changementDuBlocCasser;

		return indiceBloc;

	}

}
