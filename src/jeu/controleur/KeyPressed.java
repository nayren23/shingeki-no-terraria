package jeu.controleur;

import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import jeu.Parametre;
import jeu.model.Heros;
import jeu.model.Personnage;
import jeu.vue.HeroVue;
import jeu.vue.HerosVieVue;
import jeu.vue.inventaire.InventaireVue;

public class KeyPressed implements EventHandler<KeyEvent>{

	private Heros hero;
	private InventaireVue inventaire;
	private HerosVieVue heroVieVue;
	private HeroVue heroVue;
	private Pane panePause;
	private Timeline gameLoop;

	public KeyPressed(Personnage hero2 , HerosVieVue heroVieVue, InventaireVue inv, HeroVue heroVue,Pane panePause, Timeline gameLoop) {
		this.hero = (Heros) hero2;
		this.inventaire=inv;
		this.heroVieVue = heroVieVue;
		this.heroVue = heroVue;
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
				heroVue.changerImage("jeu/image/Eren22.png");
				hero.setDirection(-Parametre.vitessePersonnage);
				hero.setDirectionActuelle(-3);
				break;
			case LEFT:
				heroVue.changerImage("jeu/image/Eren22.png");
				hero.setDirection(-Parametre.vitessePersonnage);
				hero.setDirectionActuelle(-3);
				break;
			case D:
				heroVue.changerImage("jeu/image/Eren11.png");
				hero.setDirection(Parametre.vitessePersonnage);
				hero.setDirectionActuelle(3);
				break;
			case RIGHT:
				heroVue.changerImage("jeu/image/Eren11.png");
				hero.setDirection(Parametre.vitessePersonnage);
				hero.setDirectionActuelle(3);
				break;
			case SPACE:
				hero.sauter();

				break;
				// option pour enlever rajouter des pv 
			case F1:
				System.out.println("enlever vie");
				hero.perdrePv();
				System.out.println(hero.PvProperty());
				break;	
			case I: 
				inventaire.afficherInventaire();
				break;	

			case ESCAPE: 
				System.out.println("\n affichage echape");

				//methodes de la pause
				if (panePause.isVisible()== true) {
					panePause.setVisible(false);
					System.out.println("pause");
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