package jeu.vue.inventaire;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import jeu.model.inventaire.Inventaire;

public class InventaireVue extends Pane{

	private Inventaire inventaire;
	private int[] objet;
	private TilePane afficherInventaire;

	public InventaireVue(Inventaire inventaire, TilePane inv) {
		this.inventaire = inventaire;
		this.afficherInventaire=inv;
		initialiserInventaire();
		this.afficherInventaire.setVisible(false);
	}

	public final ImageView [] tableauImageInventaire() {
		ImageView tableauImage[] = new ImageView[11];
		tableauImage[0]= new ImageView (new Image("jeu/image/inventaire/epeeInventaire.png"));
		tableauImage[1]= new ImageView (new Image("jeu/image/inventaire/painInventaire.png"));
		tableauImage[2]= new ImageView (new Image("jeu/image/inventaire/hacheInventaire.png"));
		tableauImage[3]= new ImageView (new Image("jeu/image/inventaire/pelleInventaire.png"));
		tableauImage[4]= new ImageView (new Image("jeu/image/inventaire/piocheInventaire.png"));
		//tableauImage[5]= new Image("jeu/image/inventaire/painInventaire.png");
		//tableauImage[6]= new Image("jeu/image/inventaire/painInventaire.png");
		//tableauImage[7]= new Image("jeu/image/inventaire/painInventaire.png");
		//tableauImage[8]= new Image("jeu/image/inventaire/painInventaire.png");	
		//tableauImage[9]= new Image("jeu/image/inventaire/painInventaire.png");
		//tableauImage[10]= new Image("jeu/image/inventaire/painInventaire.png");
		//tableauImage[11]= new Image("jeu/image/inventaire/painInventaire.png");
		return tableauImage;
	}

	public void initialiserInventaire () {
		ImageView imgInventaire = null;
		for(int cases = 0; cases < 20 ; cases++) {
			imgInventaire = new ImageView(new Image("jeu/image/inventaire/caseInventaire.png"));
			this.afficherInventaire.getChildren().add(imgInventaire);
		}
	}
	
	public void afficherInventaire () {
		if (afficherInventaire.isVisible())
			afficherInventaire.setVisible(false);
		else
			afficherInventaire.setVisible(true);
	}

}