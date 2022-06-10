package jeu.controleur;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
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

	public KeyPressed(Personnage hero2 , HerosVieVue heroVieVue, InventaireVue inv, HeroVue heroVue) {
		this.hero = (Heros) hero2;
		this.inventaire=inv;
		this.heroVieVue = heroVieVue;
		this.heroVue = heroVue;
		
	}

	@Override
	//Deplacement
	public void handle(KeyEvent event) {

		switch(event.getCode()) {
		case Q:
			heroVue.changerImage("jeu/image/Eren22.png");
			hero.setDirection(-Parametre.vitessePersonnage);
			break;
		case LEFT:
			heroVue.changerImage("jeu/image/Eren22.png");
			hero.setDirection(-Parametre.vitessePersonnage);
			break;
		case D:
			heroVue.changerImage("jeu/image/Eren11.png");
			hero.setDirection(Parametre.vitessePersonnage);
			break;
		case RIGHT:
			heroVue.changerImage("jeu/image/Eren11.png");
			hero.setDirection(Parametre.vitessePersonnage);
			break;
		case SPACE:
			this.hero.setDirY(-Parametre.hauteurSautPersonnage);
			this.hero.setSpace(true);

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
		default:
			System.out.println("Entree incorrecte" );
            break;       
		}
	}
}