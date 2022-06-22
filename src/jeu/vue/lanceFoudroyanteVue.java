package jeu.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import jeu.model.Environnement;
import jeu.model.inventaire.arme.LanceFoudroyante;

public class lanceFoudroyanteVue extends ImageView {

	private Image image = new Image("jeu/image/inventaire/lanceFoudroyanteInventaire(1).png");
	private Pane PanePrincipale;
	public lanceFoudroyanteVue(LanceFoudroyante lance,Pane PanePrincipale, Environnement env) {
		this.setImage(image);
		this.PanePrincipale =PanePrincipale;
		lance.getPv().addListener((obs,old,newP) -> { 
			if(lance.estMort() ) { 
				supprimerLance();
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
		


	}
	
}
