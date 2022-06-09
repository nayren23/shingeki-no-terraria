package jeu.vue;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import jeu.model.Heros;

public class HeroVue extends ImageView{

	private Heros h;
	private Image image = new Image("jeu/image/Eren11.png"), image2 = new Image ("jeu/image/Eren22.png") ;

	public HeroVue(Heros h) {			// initialisation de l'image et de ses coordoonées de base 
		super();
		this.h = h;
		this.h.setX(200);
		this.h.setY(417);
		this.setImage(image);
	}

	public void affichageEren(Heros h) {
		this.translateXProperty().bind(h.xProperty());	//la position du hero va être mise à jour en mm temps que la position du hero dans la vue
		this.translateYProperty().bind(h.yProperty());
		
	}



	public void changerImage(String image) {
		Image monImage = new Image(image);
		this.setImage(monImage);
	}

}
