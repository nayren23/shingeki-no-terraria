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
		
		case F1:
			hero.perdrePv();
// faire un clear
			heroVue.affichageVie(hero.getPv().getValue());
			System.out.println(hero.getPv());
			break;

		default:
			System.out.println("Entrée incorrecte"  );
            break;
		}
	}
}