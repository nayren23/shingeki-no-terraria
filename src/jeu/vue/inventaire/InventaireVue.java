package jeu.vue.inventaire;

import java.util.Map;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import jeu.model.inventaire.Inventaire;
import jeu.model.inventaire.Objet;

public class InventaireVue extends Pane{

	private Inventaire inventaire;
	private TilePane afficherInventaire;
	private TilePane afficherObjet;
	private Map <String, Image> images;
	private ImageView tableauImage[];

	public InventaireVue(Inventaire inventaire, TilePane inv, TilePane obj) {
		this.inventaire = inventaire;
		this.afficherInventaire=inv;
		this.afficherObjet=obj;
		initialiserInventaire();
		this.afficherInventaire.setVisible(false);
		this.tableauImage = new ImageView[12];

	}

	private final void tableauImageInventaire() {
		this.tableauImage[0]= new ImageView (new Image("jeu/image/inventaire/epeeInventaire.png"));
		this.tableauImage[1]= new ImageView (new Image("jeu/image/inventaire/piocheInventaire.png"));
		this.tableauImage[2]= new ImageView (new Image("jeu/image/inventaire/hacheInventaire.png"));
		this.tableauImage[3]= new ImageView (new Image("jeu/image/inventaire/pelleInventaire.png"));
		this.tableauImage[4]= new ImageView (new Image("jeu/image/inventaire/lanceFoudroyanteInventaire.png"));
		this.tableauImage[5]= new ImageView (new Image("jeu/image/inventaire/boisInventaire.png"));
		this.tableauImage[6]= new ImageView (new Image("jeu/image/inventaire/charbonInventaire.png"));
		this.tableauImage[7]= new ImageView (new Image("jeu/image/inventaire/ferInventaire.png"));
		this.tableauImage[8]= new ImageView (new Image("jeu/image/inventaire/gazInventaire.png"));	
		this.tableauImage[9]= new ImageView (new Image("jeu/image/inventaire/liquideTitanInventaire.png"));
		this.tableauImage[10]= new ImageView (new Image("jeu/image/inventaire/painInventaire.png"));
		this.tableauImage[11]= new ImageView (new Image("jeu/image/inventaire/potionTitanInventaire.png"));
		this.tableauImage[12]= new ImageView (new Image("jeu/image/inventaire/terreTitanInventaire.png"));
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
	
	//affiche l'inventaire avec les objets qui sont dedans
	public void mettreAJourInventaire () {
		for (int i=0; i<20; i++) {
			int cas = this.inventaire.getInventaire().get(i).getIdObjet();
			switch (cas) {
			
			case 0:
				this.afficherObjet.getChildren().add(this.tableauImage[0]);
				break;
				
			case 1:
				this.afficherInventaire.getChildren().add(this.tableauImage[1]);
				break;
			
			case 2:
				this.afficherInventaire.getChildren().add(this.tableauImage[2]);
				break;
				
			case 3:
				this.afficherInventaire.getChildren().add(this.tableauImage[3]);
				break;
				
			case 4:
				this.afficherInventaire.getChildren().add(this.tableauImage[4]);
				break;
				
			case 5:
				this.afficherInventaire.getChildren().add(this.tableauImage[5]);
				break;
				
			case 6:
				this.afficherInventaire.getChildren().add(this.tableauImage[6]);
				break;
				
			case 7:
				this.afficherInventaire.getChildren().add(this.tableauImage[7]);
				break;
				
			case 8:
				this.afficherInventaire.getChildren().add(this.tableauImage[8]);
				break;
				
			case 9:
				this.afficherInventaire.getChildren().add(this.tableauImage[9]);
				break;
				
			case 10:
				this.afficherInventaire.getChildren().add(this.tableauImage[10]);
				break;
				
			case 11:
				this.afficherInventaire.getChildren().add(this.tableauImage[11]);
				break;
				
			default:
				this.afficherInventaire.getChildren().add(null);
			}
		}
	}

}