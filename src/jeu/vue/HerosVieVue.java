package jeu.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import jeu.model.Heros;

public class HerosVieVue extends Pane  {

	private Heros hero;
	private Pane PanePrincipale;
	private ImageView imageCoeur;
	private Image tableauImage [];

	public HerosVieVue(Heros hero, Pane PanePrincipale) {
		this.hero = hero;
		this.PanePrincipale = PanePrincipale;
		this.imageCoeur = new ImageView(); //faire aussi �a dans la map

		//Redimensionne l'image mais changer et redimenssionner directement les images eux memes
		imageCoeur.setFitHeight(75); //taille image
		imageCoeur.setFitWidth(75);	 //taille image
		
		//Place l'image au bon endroit
		imageCoeur.setX(1200); //droite ou gauche
		imageCoeur.setY(10);// pour monter le coeur

		////On ajoute le coeur au pane Principale
		PanePrincipale.getChildren().add(imageCoeur); //afficher les coeurs
		this.tableauImage = new Image[10] ;

		//Creation qu'une seule fois des images pour optimisation du programme
		tableauImageCoeur();
		
		//listener pour la vie du hero
		hero.PvProperty().addListener((obs,old,newP) -> { 
			affichageVie(newP);
		});
	}


	//Creation d'un tableau pour stocker les images pour eviter leur creation a chaque fois
	private void tableauImageCoeur() {
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
	}
	
	/**
	 * Cette methode affiche les coeuar en fonction des pv restant au hero
	 * @param pv mais le changer par un listener
	 */
	public void affichageVie(Number newPv) {
		switch(hero.PvProperty().getValue()) { // changer avec un listener
		case 0 :
			imageCoeur.setImage(tableauImage[0]);
			break;

		case 1 :
			imageCoeur.setImage(tableauImage[1]);
			break;

		case 2 :
			imageCoeur.setImage(tableauImage[2]);
			break;

		case 3 :
			imageCoeur.setImage(tableauImage[3]);
			break;
			
		case 4 :
			imageCoeur.setImage(tableauImage[4]);
			break;

		case 5 :
			imageCoeur.setImage(tableauImage[5]);
			break;

		case 6 :
			imageCoeur.setImage(tableauImage[6]);
			break;

		case 7 :
			imageCoeur.setImage(tableauImage[7]);
			break;
			
		case 8 :
			imageCoeur.setImage(tableauImage[8]);
			break;
			
		case 9 :
			System.out.println(imageCoeur);
			imageCoeur.setImage(tableauImage[9]);
			break;

		default : 
			imageCoeur = null;
			break;
		}
	}
}