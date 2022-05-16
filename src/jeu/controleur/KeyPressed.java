package jeu.controleur;

import javax.jws.soap.SOAPBinding.ParameterStyle;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import jeu.Parametre;
import jeu.model.Heros;
import jeu.model.Personnage;
import jeu.vue.PersonnageVue;

public class KeyPressed implements EventHandler<KeyEvent>{

	private Heros hero;
	

	public KeyPressed(Personnage hero2 , PersonnageVue pers1) {
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
			
		default:
			System.out.println("Entrée incorrecte");
            break;
		}
	}
}

