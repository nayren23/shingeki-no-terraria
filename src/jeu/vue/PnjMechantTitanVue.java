package jeu.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import jeu.controleur.MouseClickInventaire;
import jeu.controleur.MouseClickPnj;
import jeu.model.PnjMechantTitan;

public class PnjMechantTitanVue extends ImageView {

	
	private PnjMechantTitan pnj;
	private Image image = new Image("jeu/image/Reiner.png");

	public PnjMechantTitanVue (PnjMechantTitan pnj) {			// initialisation de l'image et de ses coordoonées de base 
		super();
		this.pnj = pnj;
		this.pnj.setX(600);
		this.pnj.setY(360);
		this.setImage(image);
		this.addEventHandler(MouseEvent.MOUSE_CLICKED, new MouseClickPnj(pnj.getEnv(),this));

	}

	public void affichageTitan(PnjMechantTitan pnj) {
		this.translateXProperty().bind(pnj.xProperty());	//la position du hero va être mise à jour en mm temps que la position du hero dans la vue
		this.translateYProperty().bind(pnj.yProperty());
		System.out.println("\n Affichage du x pnj" + xProperty());
//		changerImage();
	}
	
	public void mort () {
		
		if (pnj.getPvProperty().getValue() <=0) {
			this.setVisible(false);
		}
	}
}
