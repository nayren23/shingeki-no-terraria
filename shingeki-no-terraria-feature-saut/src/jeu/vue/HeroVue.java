package jeu.vue;

import javafx.beans.property.IntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import jeu.model.Heros;
import jeu.model.Personnage;

public class HeroVue extends ImageView{
	
	@FXML
	private ImageView eren;
	
	
	private Heros h;
	//mettre le bind et l'image du personnage

	public HeroVue(Heros h) {
		creeVueHero();
		this.h = h;
		this.translateXProperty().bind(h.xProperty());	//la position du cercle va être mise à jour en mm temps que la position du personnage
		this.translateYProperty().bind(h.yProperty());
		
	}
	
	public void creeVueHero() {
		eren.setLayoutX(200);
		eren.setLayoutY(185);
		eren.toFront();
	}
	
	
}
