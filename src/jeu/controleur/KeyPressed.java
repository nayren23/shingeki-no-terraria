package jeu.controleur;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import jeu.Parametre;
import jeu.model.Heros;
import jeu.model.Personnage;
import jeu.vue.HerosVieVue;
import jeu.vue.PersonnageVue;
import jeu.vue.inventaire.InventaireVue;

public class KeyPressed implements EventHandler<KeyEvent>{

	private Heros hero;
	private InventaireVue inventaire;
	private HerosVieVue heroVue;

	public KeyPressed(Personnage hero2 , HerosVieVue heroVue, InventaireVue inv) {
		this.hero = (Heros) hero2;
		this.inventaire=inv;
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

			
			heroVue.affichageVie(hero.PvProperty().getValue());
			System.out.println(hero.PvProperty());
			break;

		case F2:
			System.out.println("OK");
			hero.augmenterPv(); //test pour voir si le coeur change d'image quand on augmente les pv

			heroVue.affichageVie(hero.PvProperty().getValue()); //rafraichir la vue du coeur
			System.out.println(hero.PvProperty());
			break;	
			
		case I: 
			inventaire.afficherInventaire();
			break;
		default:
			System.out.println("Entr�e incorrecte"  );
            break;
		}
	}
}