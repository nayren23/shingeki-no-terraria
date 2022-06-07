package jeu.controleur;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import jeu.model.Environnement;
import jeu.model.inventaire.Objet;
import jeu.model.inventaire.arme.Arme;
import jeu.model.inventaire.arme.Epee;
import jeu.model.inventaire.outil.Pioche;
import jeu.vue.PnjMechantTitanVue;

public class MouseClickPnj implements EventHandler<MouseEvent> {
	
	Environnement env;
	PnjMechantTitanVue titanVue;
	
	public MouseClickPnj(Environnement env, PnjMechantTitanVue titanVue) {
		this.env = env;
		this.titanVue = titanVue;
	}

	@Override
	public void handle(MouseEvent arg0) {
		
		Objet objet = this.env.getEren().getObjetHeros();

		if(objet instanceof Epee && arg0.getButton() == MouseButton.PRIMARY ) {
			Arme arme = (Arme) objet;
			env.getTitans().perdrePv(arme);
			arme.decrementerDurabiliteArme(arme);
			System.out.println("\n Affichage durabilite arme " + arme.getDurabilite());
			System.out.println(" \nAffichage pv " + env.getTitans().PvProperty().getValue());
			titanVue.mort();
		}

		
	}

}
