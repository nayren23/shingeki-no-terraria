package jeu.vue;


import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import jeu.Parametre;
import jeu.model.Heros;

public class HeroVue extends ImageView{

	private Heros h;
	private Image image = new Image("jeu/image/Eren11.png"), image2 = new Image ("jeu/image/Eren22.png") ;
	private Pane gameOver;
	private Timeline gameLoop;

	public HeroVue(Heros h, Pane gameOver , Timeline gameLoop) {			// initialisation de l'image et de ses coordoonées de base 
		super();
		this.h = h;
		this.h.setX(125);
		this.h.setY(417);
		this.setImage(image);
		this.gameOver = gameOver;
		this.gameLoop = gameLoop;

		//listener des pv quan eren mort
		h.PvProperty().addListener((obs,old,newP) -> { 
			if(h.estMort()) {
				changerImage("jeu/image/erenMort.png")	;
				gameOver.setVisible(true);
				gameLoop.pause(); // on met tout en pause 
				Parametre.sonMapTitan.stopSound();
				Parametre.sonGameOverFinaleTatakae.playSound();
			}
		});
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
