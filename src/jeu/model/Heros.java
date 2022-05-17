
package jeu.model;

import javafx.beans.property.IntegerProperty;
import jeu.Parametre;

public class Heros extends Personnage{

	//changer le type terrain en type environnement
	public Heros(int x, int y, Terrain terrain) {
		super(x, y, 5, 9, terrain);
	}

	@Override
	public void seDeplace(Parametre.DIRECTION d) {
		switch(d) {
		case LEFT:
			this.getxProp().setValue(getxProp().getValue() - 6);
			break;

		case RIGHT:
			this.getxProp().setValue(getxProp().getValue() + 6);
			break;
			
		default:
			System.out.println("EntrÃ©e incorrecte");
            break;
		}
	}

	@Override
	public void perdrePv() {
		this.getPv().setValue(this.getPv().getValue()-1);  // -1 pour le héros 
	}
	
}
