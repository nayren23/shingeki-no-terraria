
package jeu.model;

import jeu.Parametre;
import jeu.controleur.MouseClick;
import jeu.controleur.MouseMoved;

public class Heros extends Personnage{

	private MouseMoved sourisCoordonnées;
	//changer le type terrain en type environnement
	public Heros(int x, int y, Terrain terrain) {
		super(x, y, 5, 9, terrain);
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
			System.out.println("EntrÃ©e incorrecte");
			break;
		}
	}

	private int clamp (int val1 , int min, int max) {  // Pour borner un chiffre entre 2valeur pour pas que l'image s'enleve
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
	public void perdrePv() { // en option mettre le nb de pv perdu en paramètre
			
			int pv = clamp(this.PvProperty().getValue()-1, 0, 9);
			this.PvProperty().setValue(pv);  // -1 pour le héros 
		}
	

	@Override
	public void augmenterPv() { // en option mettre le nb de pv augmenter en paramètre

			int pv = clamp(this.PvProperty().getValue()+1, 0, 9);	
			this.PvProperty().setValue(pv);  // -1 pour le héros 
	}

	public void miner () {
		
	}
//	public boolean estMort(int pv) { // a finir
//			boolean estMort = false;
//			
//			if(pv==0) {
//				estMort =true;
//			}
//			return estMort;
//			
//	}
	
	
	
	

}
