package jeu.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import jeu.controleur.MouseClickInventaire;
import jeu.controleur.MouseClickPnj;
import jeu.model.Heros;
import jeu.model.PnjMechantTitan;
import jeu.model.inventaire.Objet;
import jeu.model.inventaire.arme.Arme;
import jeu.model.inventaire.arme.Epee;

public class PnjMechantTitanVue extends ImageView {

	
	private PnjMechantTitan pnj;
	private Image image = new Image("jeu/image/Reiner.png");
	private Heros hero;

	public PnjMechantTitanVue (PnjMechantTitan pnj ,Heros hero) {			// initialisation de l'image et de ses coordoonées de base 
		this.pnj = pnj;
//		this.pnj.setX(200);
//		this.pnj.setY(360);
		this.setImage(image);
		this.addEventHandler(MouseEvent.MOUSE_CLICKED, new MouseClickPnj(pnj.getEnv(),this));
		this.hero = hero;
		setOnClickListener(); //appelle du listener

	}

	public void affichageTitan(PnjMechantTitan pnj) {
		this.translateXProperty().bind(pnj.xProperty());	//la position du hero va être mise à jour en mm temps que la position du hero dans la vue
		this.translateYProperty().bind(pnj.yProperty());
		System.out.println("\n Affichage du x pnj" + xProperty());
//		changerImage();
	}
	
	public void mort () {
		
		if (pnj.verificationMort() == true ) {
			this.setVisible(false);
		}
	}


	
	private void setOnClickListener () {
	
		//Listener
		this.setOnMouseClicked(e -> {
			Objet objet = this.hero.getObjetHeros();

			if(objet instanceof Epee) {
				Arme arme = (Arme) objet;

				this.pnj.perdrePv(arme);
				System.out.println("\n Affichage pv titans " + this.pnj.PvProperty());
		
				arme.decrementerDurabiliteArme(arme);
				this.mort();
			}
		});
	}
}
