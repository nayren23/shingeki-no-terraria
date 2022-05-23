package jeu.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import jeu.model.Personnage;

public class HerosVieVue extends Pane  {

	private Personnage hero;
	private Pane PanePrincipale;
	private ImageView imageCoeur;

	public HerosVieVue(Personnage hero, Pane PanePrincipale) {
		this.hero = hero;
		this.PanePrincipale = PanePrincipale;
		this.imageCoeur = new ImageView(); //faire aussi ça dans la map
		PanePrincipale.getChildren().add(imageCoeur); //afficher les coeurs
	}


	//Création d'un tableua pour stocker les images pour éviter leur création à chaque fois
	public final Image [] tableauImageCoeur() {
		Image tableauImage [] = new Image[10] ;
		tableauImage[0] = new Image("jeu/image/coeur/coeur10.png");
		tableauImage[1] = new Image("jeu/image/coeur/coeur9.png");
		tableauImage[2] = new Image("jeu/image/coeur/coeur8.png");
		tableauImage[3] = new Image("jeu/image/coeur/coeur7.png");
		tableauImage[4] = new Image("jeu/image/coeur/coeur6.png");
		tableauImage[5] = new Image("jeu/image/coeur/coeur5.png");
		tableauImage[6] = new Image("jeu/image/coeur/coeur4.png");
		tableauImage[7] = new Image("jeu/image/coeur/coeur3.png");
		tableauImage[8] = new Image("jeu/image/coeur/coeur2.png");
		tableauImage[9] = new Image("jeu/image/coeur/coeur1.png");
		return tableauImage;
	}

	

	public void affichageVie(int pv) {

		switch(hero.PvProperty().getValue()) { // changer avec un listener

		case 0 :
			imageCoeur.setImage(tableauImageCoeur()[0]);
			break;

		case 1 :
			imageCoeur.setImage(tableauImageCoeur()[1]);
			break;

		case 2 :
			imageCoeur.setImage(tableauImageCoeur()[2]);
			break;

		case 3 :
			imageCoeur.setImage(tableauImageCoeur()[3]);
			break;
		case 4 :
			imageCoeur.setImage(tableauImageCoeur()[4]);
			break;

		case 5 :
			imageCoeur.setImage(tableauImageCoeur()[5]);
			break;

		case 6 :
			imageCoeur.setImage(tableauImageCoeur()[6]);
			break;

		case 7 :
			imageCoeur.setImage(tableauImageCoeur()[7]);
			break;
		case 8 :
			imageCoeur.setImage(tableauImageCoeur()[8]);
			break;
		case 9 :
			System.out.println(imageCoeur);
			imageCoeur.setImage(tableauImageCoeur()[9]);
			break;

		default : 
			imageCoeur = null;
			break;
		}
		imageCoeur.setFitHeight(75); //taille image
		imageCoeur.setFitWidth(75);	 //taille image
		imageCoeur.setX(1200); //droite ou gauche
		imageCoeur.setY(10);// pour monter le coeur
	}

}