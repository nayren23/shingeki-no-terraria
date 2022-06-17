package jeu.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import jeu.model.Personnage;

public class PnjGentilVue extends ImageView{
	
	private Personnage erwin;
	private Image imageErwin = new Image("jeu/image/erwin.png");
	
	public PnjGentilVue (Image image) {
		this.setX(50);
		this.setY(435);
		this.setImage(image);
	}

}
