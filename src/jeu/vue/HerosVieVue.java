package jeu.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import jeu.model.Personnage;

public class HerosVieVue extends Pane  {

	private Personnage hero;

	private TilePane tuilesFond;
	private Pane PaneVieHero;
	private ImageView image;

	public HerosVieVue(Personnage hero, TilePane tuilesFond) {
		this.hero = hero;
		this.tuilesFond=tuilesFond;
		
		
		this.PaneVieHero = new Pane();
		this.PaneVieHero.setMaxWidth(15);
		this.PaneVieHero.setMaxHeight(10);
		this.PaneVieHero.setLayoutX(500);
		this.PaneVieHero.setLayoutY(100);
		this.PaneVieHero.setVisible(true);
		this.tuilesFond.getChildren().add(this.PaneVieHero);
	}

	
	public void clearPanVieHero() {  // pour éviter que  les coeur s'affiche en meme temp
		this.PaneVieHero.getChildren().clear();
	}

	public void affichageVie(int pv) {
		

		ImageView imageCoeur;
		switch(hero.PvProperty().getValue()) {

		case 0 :
			imageCoeur = new ImageView(new Image("jeu/image/coeur/coeur10.png"));
			break;

		case 1 :
			imageCoeur = new ImageView(new Image("jeu/image/coeur/coeur9.png"));
			break;

		case 2 :
			imageCoeur = new ImageView(new Image("jeu/image/coeur/coeur8.png"));
			break;

		case 3 :
			imageCoeur = new ImageView(new Image("jeu/image/coeur/coeur7.png"));
			break;
		case 4 :
			imageCoeur = new ImageView(new Image("jeu/image/coeur/coeur6.png"));
			break;

		case 5 :
			imageCoeur = new ImageView(new Image("jeu/image/coeur/coeur5.png"));
			break;

		case 6 :
			imageCoeur = new ImageView(new Image("jeu/image/coeur/coeur4.png"));
			break;

		case 7 :
			imageCoeur = new ImageView(new Image("jeu/image/coeur/coeur3.png"));
			break;
		case 8 :
			imageCoeur = new ImageView(new Image("jeu/image/coeur/coeur2.png"));
			break;
		case 9 :
			imageCoeur = new ImageView(new Image("jeu/image/coeur/coeur1.png"));
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