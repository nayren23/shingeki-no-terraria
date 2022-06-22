package jeu.controleur;

import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import jeu.Parametre;
import jeu.model.Heros;
import jeu.model.Personnage;
import jeu.vue.inventaire.InventaireVue;

public class KeyPressed implements EventHandler<KeyEvent>{

	private Heros hero;
	private InventaireVue inventaire;
	private Pane panePause;
	private Timeline gameLoop;

	public KeyPressed(Personnage hero2 ,  InventaireVue inv,Pane panePause, Timeline gameLoop) {
		this.hero = (Heros) hero2;
		this.inventaire=inv;
		this.panePause = panePause;
		this.gameLoop = gameLoop;
	}

	@Override
	//Deplacement
	public void handle(KeyEvent event) {

		// si pas mort alors peut bouger
		if(!hero.estMort()) {
			switch(event.getCode()) {
			case Q:
				hero.setDirection(-Parametre.vitessePersonnage);
				hero.setDirectionActuelle(-3);
				break;
			case LEFT:
				hero.setDirection(-Parametre.vitessePersonnage);
				hero.setDirectionActuelle(-3);
				break;
			case D:
				hero.setDirection(Parametre.vitessePersonnage);
				hero.setDirectionActuelle(3);
				break;
			case RIGHT:
				hero.setDirection(Parametre.vitessePersonnage);
				hero.setDirectionActuelle(3);
				break;
			case SPACE:
				hero.sauter();
				break;
				// option pour enlever rajouter des pv 
			case F1:
				hero.perdrePv();
				break;	
			case I: 
				inventaire.afficherInventaire();
				break;	

			case ESCAPE: 

				//methodes de la pause
				if (panePause.isVisible()== true) {
					panePause.setVisible(false);
					gameLoop.play();
				}

				else {
					panePause.setVisible(true);
					gameLoop.pause();
				}
				break;	

			default:
				System.out.println("Entree incorrecte" );
				break;       
			}
		}
	}
}