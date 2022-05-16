package jeu.model;

import javafx.beans.property.IntegerProperty;
import jeu.Parametre;
import jeu.controleur.KeyPressed;

public class Heros extends Personnage{

	//changer le type terrain en type environnement
	public Heros(int x, int y, Terrain terrain) {
		super(x, y, 5, 6, terrain);
			
	}

	@Override
	public void seDeplace(Parametre.DIRECTION d) {
		switch(d) {
		case LEFT:
			this.xProperty().setValue(xProperty().getValue() - 6);
			break;

		case RIGHT:
			this.xProperty().setValue(xProperty().getValue() + 6);
			break;
		
		case SPACE:
			while(getY() >= -20) {
				this.setY(getY() - 20);
			}

			break;
			
		default:
			System.out.println("Entrée incorrecte");
            break;
		}
		
	}
	
	
	
}
