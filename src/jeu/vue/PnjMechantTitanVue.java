package jeu.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import jeu.model.PnjMechantTitan;

public class PnjMechantTitanVue extends ImageView {

	
	private PnjMechantTitan pnj;
	private Image image = new Image("jeu/image/Reiner.png");

	public PnjMechantTitanVue (PnjMechantTitan pnj) {			// initialisation de l'image et de ses coordoonées de base 
		super();
		this.pnj = pnj;
		this.pnj.setX(200);
		this.pnj.setY(360);
		this.setImage(image);
	}

	public void affichageTitan(PnjMechantTitan pnj) {
		this.translateXProperty().bind(pnj.xProperty());	//la position du hero va être mise à jour en mm temps que la position du hero dans la vue
		this.translateYProperty().bind(pnj.yProperty());
//		changerImage();
	}
}
