package jeu.controleur;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import jeu.model.Heros;
import jeu.model.Personnage;

public class KeyReleased implements EventHandler<KeyEvent>{

	private Heros hero;


	public KeyReleased(Personnage hero2 ) {
		this.hero = (Heros) hero2;
	}
	
	@Override
	public void handle(KeyEvent event) {
		
		this.hero.setDirection(1);
		
	}

}
