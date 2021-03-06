package jeu.vue;


import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import jeu.Parametre;
import jeu.model.Heros;

public class HeroVue extends ImageView{

	private Image image = new Image("jeu/image/Eren11.png");
	private ArrayList<Image> images = new ArrayList<Image>();
	private int count;
	public HeroVue(Heros h, Pane gameOver , Timeline gameLoop) {			// initialisation de l'image et de ses coordoonées de base 
		super();
		this.setImage(image);
		images.add(new Image("jeu/image/ErenCour1.png"));
		images.add(new Image("jeu/image/ErenCour2.png"));
		images.add(new Image("jeu/image/ErenCour3.png"));
		images.add(new Image("jeu/image/ErenCour4.png"));
		images.add(new Image("jeu/image/ErenCour5.png"));
		images.add(new Image("jeu/image/ErenCour6.png"));

		this.count=0;
		//listener des pv quan eren mort
		h.PvProperty().addListener((obs,old,newP) -> { 
			if(h.estMort()) {
				changerImage("jeu/image/erenMort.png")    ;
				gameOver.setVisible(true);
				gameLoop.pause(); // on met tout en pause 
				Parametre.sonMapTitan.stopSound();
				Parametre.sonGameOverFinaleTatakae.playSound();
				Parametre.musicmap1.stopSound();
				Parametre.musicmap2.stopSound();
				Parametre.musicmap3.stopSound();
				Parametre.musicmap4.stopSound();
				Parametre.sonMapTitan.stopSound();
			}
		});
	}

	public void affichageEren(Heros h) {
		this.translateXProperty().bind(h.xProperty());	//la position du hero va être mise à jour en mm temps que la position du hero dans la vue
		this.translateYProperty().bind(h.yProperty());

	}
	
	//animations hero
	public void animations(Heros h) {

		if(h.getDirection() == 3) {
			if (count==60) {
				count=0;

			}
			this.setScaleX(1);

			this.setImage(images.get(count/10));
			count++;
		}
		else if (h.getDirection() == -3 ) {
			if (count==60) {
				count=0;

			}
			this.setScaleX(-1);

			this.setImage(images.get(count/10));
			count++;
		}

		else {
			this.setImage(image);
		}

	}


	public void changerImage(String image) {
		Image monImage = new Image(image);
		this.setImage(monImage);
	}

}
