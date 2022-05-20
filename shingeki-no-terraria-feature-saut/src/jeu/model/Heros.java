package jeu.model;

import javafx.animation.TranslateTransition;
import javafx.beans.property.IntegerProperty;
import javafx.scene.transform.Translate;
import javafx.util.Duration;
import jeu.Parametre;
import jeu.controleur.KeyPressed;

public class Heros extends Personnage{

	int direction;

	//changer le type terrain en type environnement
	public Heros(int x, int y, Terrain terrain) {
		super(x, y, 5, 6, terrain);

	}

	@Override
	public void seDeplace(Parametre.DIRECTION d) {
		switch(d) {
		case LEFT:
			
			this.xProperty().setValue(xProperty().getValue() - 6);
			this.direction  = -1;
			break;

		case RIGHT:
			this.xProperty().setValue(xProperty().getValue() + 6);
			this.direction = 2;
			break;


		case SPACE:
//			TranslateTransition saut = new TranslateTransition(Duration.millis(direction));
			
			if(this.direction == -1) {
				this.setY(getY() - 40);
				this.setX(getX() - 40);

			}
			else if(this.direction == 2){
				this.setY(getY() - 40);
				this.setX(getX() + 40);
			}
			else {
				this.setY(getY() - 40);
			}



			break;

		default:
			System.out.println("Entrée incorrecte");
			break;
		}


	}
	
	public int getDirection() {
		return this.direction;
	}

	public int setDirection(int i) {
		 return this.direction = i;
	}



}
