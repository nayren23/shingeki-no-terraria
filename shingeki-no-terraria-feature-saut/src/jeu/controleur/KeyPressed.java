package jeu.controleur;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import jeu.Parametre;
import jeu.model.Heros;
import jeu.model.Personnage;

public class KeyPressed implements EventHandler<KeyEvent>{

	private Heros hero;


	public KeyPressed(Personnage hero2 ) {
		this.hero = (Heros) hero2;
	}



	@Override
	//Deplacement
	public void handle(KeyEvent event) {

		switch(event.getCode()) {
		case Q:
			hero.seDeplace(Parametre.DIRECTION.LEFT);
			break;
		case LEFT:
			hero.seDeplace(Parametre.DIRECTION.LEFT);
			break;
		case D:
			hero.seDeplace(Parametre.DIRECTION.RIGHT);
			break;
		case RIGHT:
			hero.seDeplace(Parametre.DIRECTION.RIGHT);
			break;
		case SPACE:
			hero.seDeplace(Parametre.DIRECTION.SPACE);
			break;




		default:
			System.out.println("Entrée incorrecte");
			break;
		}
	}
}

