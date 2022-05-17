
package jeu.model;

import javafx.beans.property.IntegerProperty;
import jeu.Parametre;
import jeu.vue.HerosVieVue;

public class Heros extends Personnage{

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

	@Override
	public void perdrePv() {
		//if(this.PvProperty().getValue()>=0) {
//		if (verificationPv(this.PvProperty().getValue())==true) {
			this.PvProperty().setValue(this.PvProperty().getValue() -1);  // -1 pour le héros 

//		}
//		else
//			System.out.println("nop");

		//}
	}

	@Override
	public void augmenterPv() {
		//if(this.PvProperty().getValue()<10) {
//		if (verificationPv(this.PvProperty().getValue())==true) {

			
			this.PvProperty().setValue(this.PvProperty().getValue() +1);  // -1 pour le héros 
//		}
		//}

	}

//	public boolean verificationPv (int pv) {
//		boolean peutFaireAction = false;
//		
//		if(pv == -1 && pv>10) {  //changer avec 0 et 9 mais bug a cause de property
//			peutFaireAction = false;
//		}
//		else 
//			peutFaireAction = true;
//		
//		return peutFaireAction;
//	}
}
