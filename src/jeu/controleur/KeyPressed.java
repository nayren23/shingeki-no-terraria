package jeu.controleur;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import jeu.Parametre;
import jeu.model.Heros;
import jeu.model.Personnage;
import jeu.vue.HerosVieVue;

public class KeyPressed implements EventHandler<KeyEvent>{

	private Heros hero;
	private HerosVieVue heroVue;

	public KeyPressed(Personnage hero2 , HerosVieVue heroVue ) {
		this.hero = (Heros) hero2;
		this.heroVue = heroVue;
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
		
			// option pour enlever rajouter des pv 
		case F1:
			System.out.println("Pas OK");

			hero.perdrePv();
			heroVue.clearPanVieHero(); 			// faire un clear pour éviter superposition coeur

			heroVue.affichageVie(hero.PvProperty().getValue());
			System.out.println(hero.PvProperty());
			break;

		case F2:
			System.out.println("OK");
			hero.augmenterPv(); //test pour voir si le coeur change d'image quand on augmente les pv
			heroVue.clearPanVieHero();// faire un clear pour éviter superposition coeur

			heroVue.affichageVie(hero.PvProperty().getValue()); //rafraichir la vue du coeur
			System.out.println(hero.PvProperty());
			break;	
			
		default:
			System.out.println("Entrée incorrecte"  );
            break;
		}
	}
}