package jeu.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import jeu.model.Personnage;

public class HerosVieVue extends Pane  {

	private Personnage hero;

	private Pane PaneVieHero;
	private ImageView image;

	public HerosVieVue(Personnage hero) {
		this.hero = hero;
		
		
		this.PaneVieHero = new Pane();
		this.PaneVieHero.setMaxWidth(15);
		this.PaneVieHero.setMaxHeight(10);
		this.PaneVieHero.setLayoutX(500);
		this.PaneVieHero.setLayoutY(100);
		this.PaneVieHero.setVisible(true);
		this.PaneVieHero.getChildren().add(this.PaneVieHero);
	}

	
	public void clearPanVieHero() {  // pour éviter que  les coeur s'affiche en meme temp
		this.PaneVieHero.getChildren().clear();
	}

	public void affichageVie(int pv) {
		

		ImageView imageCoeur = new ImageView();
		
		Image imageduCoeur10 =new Image("jeu/image/coeur/coeur10.png");
		Image imageduCoeur9 = new Image("jeu/image/coeur/coeur9.png");
		Image imageduCoeur8= new Image("jeu/image/coeur/coeur8.png");
		Image imageduCoeur7 = new Image("jeu/image/coeur/coeur7.png");
		Image imageduCoeur6 = new Image("jeu/image/coeur/coeur6.png");
		Image imageduCoeur5 = new Image("jeu/image/coeur/coeur5.png");
		Image imageduCoeur4 = new Image("jeu/image/coeur/coeur4.png");
		Image imageduCoeur3 = new Image("jeu/image/coeur/coeur3.png");
		Image imageduCoeur2 = new Image("jeu/image/coeur/coeur2.png");
		Image imageduCoeur1 = new Image("jeu/image/coeur/coeur1.png");

		
		switch(hero.PvProperty().getValue()) {

		case 0 :
			imageCoeur.setImage(imageduCoeur10);
			break;

		case 1 :
			imageCoeur.setImage(imageduCoeur9);
			break;

		case 2 :
			imageCoeur.setImage(imageduCoeur8);
			break;

		case 3 :
			imageCoeur.setImage(imageduCoeur7);
			break;
		case 4 :
			imageCoeur.setImage(imageduCoeur6);
			break;

		case 5 :
			imageCoeur.setImage(imageduCoeur5);
			break;

		case 6 :
			imageCoeur.setImage(imageduCoeur4);
			break;

		case 7 :
			imageCoeur.setImage(imageduCoeur3);
			break;
		case 8 :
			imageCoeur.setImage(imageduCoeur2);
			break;
		case 9 :
			imageCoeur.setImage(imageduCoeur1);
			break;

		default : 
			imageCoeur = null;
			break;
		}
		imageCoeur.setFitHeight(75); //taille image
		imageCoeur.setFitWidth(75);	 //taille image
		imageCoeur.setX(1200); //droite ou gauche
		imageCoeur.setY(-720);// pour monter le coeur
		PaneVieHero.getChildren().add(imageCoeur); //afficher les coeurs

	}

}