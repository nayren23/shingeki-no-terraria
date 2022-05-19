package jeu.controleur;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import jeu.model.Heros;

public class MouseClick implements EventHandler<MouseEvent> {

	private Heros eren;
	
	public MouseClick(Heros eren) {
		this.eren = eren;
		
	}

	@Override
	public void handle(MouseEvent arg0) {
		
	}

}
