package jeu.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import jeu.model.Personnage;

public class PnjGentilVue extends ImageView{
	
	private Personnage erwin;
	private Image imageErwin = new Image("jeu/image/erwin.png");
	private int coordX, coordY;
	
	public PnjGentilVue (Image image, int coordX, int coordY) {
		this.coordX = coordX;
		this.coordY = coordY;
		this.setX(coordX);
		this.setY(coordY);
		this.setImage(image);
	}

}
