package jeu.controleur;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import jeu.model.Heros;
import jeu.model.inventaire.Objet;

public class MouseClickInventaire implements EventHandler<MouseEvent>{
	
	private Objet objet;
	private Heros eren;
	
	public MouseClickInventaire(Objet o, Heros eren) {
		this.objet = o;
		this.eren = eren;
	}

	@Override
	public void handle(MouseEvent event) {
		eren.equiper(objet);
		
	}

}
