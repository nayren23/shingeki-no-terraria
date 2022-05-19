package jeu.vue;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import jeu.controleur.KeyPressed;
import jeu.model.Heros;
import jeu.model.Personnage;

public class HeroVue extends ImageView{
	
	private Heros h;
	
	
	//@FXML
	//private ImageView eren;


	//mettre le bind et l'image du personnage

	public HeroVue(Heros h) {
		super(new Image("jeu/image/Eren1.png"));
		this.h = h;
		this.h.setX(200);
		this.h.setY(185);


	}
	
	public void affichageEren(Heros h) {
		this.translateXProperty().bind(h.xProperty());	//la position du cercle va être mise à jour en mm temps que la position du personnage
		this.translateYProperty().bind(h.yProperty());
	
	}
	
}
