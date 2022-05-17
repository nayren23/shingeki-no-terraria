package jeu.vue;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.EventHandler;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import jeu.model.Heros;
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





	public void affichageVie(int pv) {
		
		//	ps1.bind(hero.getPv());
		//	this.translateXProperty().bind(p.getX());	//la position du cercle va être mise à jour en mm temps que la position du personnage

		

		ImageView img;
		switch(hero.getPv().getValue()) {

		case 0 :
			img = new ImageView(new Image("jeu/image/coeur10.png"));
			break;

		case 1 :
			img = new ImageView(new Image("jeu/image/coeur9.png"));
			break;

		case 2 :
			img = new ImageView(new Image("jeu/image/coeur8.png"));
			break;

		case 3 :
			img = new ImageView(new Image("jeu/image/coeur7.png"));
			break;
		case 4 :
			img = new ImageView(new Image("jeu/image/coeur6.png"));
			break;

		case 5 :
			img = new ImageView(new Image("jeu/image/coeur5.png"));
			break;

		case 6 :
			img = new ImageView(new Image("jeu/image/coeur4.png"));
			break;

		case 7 :
			img = new ImageView(new Image("jeu/image/coeur3.png"));
			break;
		case 8 :
			img = new ImageView(new Image("jeu/image/coeur2.png"));
			break;
		case 9 :
			img = new ImageView(new Image("jeu/image/coeur1.png"));
			break;

		default : 
			img = null;
			break;
		}
		img.setFitHeight(75);
		img.setFitWidth(75);
		img.setX(1200); //droite ou gauche
		img.setY(-720);// pour monter le coeur
		PaneVieHero.getChildren().add(img);

	}

}
