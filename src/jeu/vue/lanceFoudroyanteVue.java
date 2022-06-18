package jeu.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import jeu.Parametre;
import jeu.model.Environnement;
import jeu.model.PnjMechantTitan;
import jeu.model.inventaire.arme.LanceFoudroyante;

public class lanceFoudroyanteVue extends ImageView {

	private LanceFoudroyante lance ;
	private Image image = new Image("jeu/image/inventaire/lanceFoudroyanteInventaire(1).png");
	private Pane PanePrincipale;
	private Environnement env;




	public lanceFoudroyanteVue(LanceFoudroyante lance,Pane PanePrincipale, Environnement env) {
		this.lance = lance;
		this.setImage(image);
		this.PanePrincipale =PanePrincipale;
		this.env =env;

		lance.getPv().addListener((obs,old,newP) -> { 
			if(lance.estMort() ) { 
				supprimerLance();
				//				Parametre.mortTitan.playSound();
				System.out.println("meurrrr");
			}
		});

	}

	/**
	 * agit en fonction du listener listeTitans quand un titan disparrait du modele on supprime son image
	 */
	public void supprimerLance () {
		this.PanePrincipale.getChildren().remove(this);  // on supprime l'image associer
	}



	/**
	 * 
	 * @param bind les coordonne du pnj avec celle de son image
	 */
	public void affichageTitan(LanceFoudroyante lance) {
		this.translateXProperty().bind(lance.getCoordonneeX());	//la position du hero va être mise à jour en mm temps que la position du hero dans la vue
		this.translateYProperty().bind(lance.getCoordonneeY());
		System.out.println("\n Affichage du x lance" +lance.getCoordonneeX().getValue());
		System.out.println("\n Affichage du y lance" + lance.getCoordonneeY().getValue());

		//		changerImage();
	}
	
}
