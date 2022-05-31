package jeu.model;

import jeu.Parametre;
import jeu.controleur.MouseMoved;
import jeu.model.inventaire.Inventaire;

public class Heros extends Personnage{

	private MouseMoved sourisCoordonnee;
	private Terrain terrain;
	private Inventaire inventaireHeros;
	//changer le type terrain en type environnement
	public Heros(int x, int y, Terrain terrain, Inventaire inventaire) {
		super(x, y, 5, 9, terrain);
		this.inventaireHeros=inventaire;
	}

	@Override
	public void seDeplace(Parametre.DIRECTION d) {
		switch(d) {
		case LEFT:
			this.CoordonneeXProperty().setValue(CoordonneeXProperty().getValue() - 6);
			break;

		case RIGHT:
			this.CoordonneeXProperty().setValue(CoordonneeXProperty().getValue() + 6);
			break;

		default:
			System.out.println("Entree incorrecte");
			break;
		}
	}

	private int clamp (int val1 , int min, int max) {  // Pour borner un chiffre entre 2 valeurs pour pas que l'image s'enleve
		int valeurClamp = val1;

		if(valeurClamp<min) {
			valeurClamp = min;
		}
		else if(valeurClamp>max) {
			valeurClamp= max;
		}
		return valeurClamp;
	}

	@Override
	public void perdrePv() { // en option mettre le nb de pv perdu en param�tre
		int pv = clamp(this.PvProperty().getValue()-1, 0, 9);
		this.PvProperty().setValue(pv);  // -1 pour le heros 
	}

	@Override
	public void augmenterPv() { // en option mettre le nb de pv augmenter en parametre
		int pv = clamp(this.PvProperty().getValue()+1, 0, 9);	
		this.PvProperty().setValue(pv);  // -1 pour le heros 
	}

	public void miner (int numeroTuilesCasser, Terrain terrain) {  // ensuite rajouter l'objet miner dans l'inventaire 
		System.out.println("minage" + numeroTuilesCasser);
		System.out.println("Affichage du terrain"+terrain.getTerrain());
		terrain.affichertableau(terrain);
		terrain.changerTuiles(numeroTuilesCasser);
		System.out.println("C'est cassee Yes");			
		terrain.affichertableau(terrain);
	}

	//	public void construire(Terrain terrain) {
	//		
	//	}
}
//	public boolean estMort(int pv) { // a finir
//			boolean estMort = false;
//			
//			if(pv==0) {
//				estMort =true;
//			}
//			return estMort;
//			
//}