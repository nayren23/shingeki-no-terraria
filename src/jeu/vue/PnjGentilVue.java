package jeu.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PnjGentilVue extends ImageView{
	
	public PnjGentilVue (Image image, int coordX, int coordY) {
		this.setX(coordX);
		this.setY(coordY);
		this.setImage(image);
	}

}
