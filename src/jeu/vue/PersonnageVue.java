package jeu.vue;

import javafx.scene.shape.Circle;
import jeu.model.Personnage;

public class PersonnageVue extends Circle{
	
	private Personnage p;
	//mettre le bind et l'image du personnage

	public PersonnageVue(Personnage p) {
		creeCercle();
		this.p = p;
		this.translateXProperty().bind(p.getX());	//la position du cercle va être mise à jour en mm temps que la position du personnage
		this.translateYProperty().bind(p.getY());
	}
	
	public void creeCercle() {
		this.setRadius(10);
		this.setCenterX(200);
		this.setCenterY(370);
	}
	
}
