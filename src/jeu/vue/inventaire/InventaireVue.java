package jeu.vue.inventaire;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import jeu.controleur.MouseClickInventaire;
import jeu.controleur.listener.InventaireListener;
import jeu.model.Heros;
import jeu.model.inventaire.Inventaire;

public class InventaireVue extends Pane{

	private Inventaire inventaire;
	private TilePane afficherInventaire;
	private TilePane afficherObjet;
	private Image tableauImage[];
	private Heros eren;

	public InventaireVue(Inventaire inventaire, TilePane inv, TilePane obj,Heros eren) {
		this.eren = eren;
		this.inventaire = inventaire;
		this.afficherInventaire=inv;
		this.afficherObjet=obj;
		this.tableauImage = new Image [13];
		new InventaireListener(this, this.inventaire);
		initialiserInventaire();
		tableauImageInventaire();
		this.afficherInventaire.setVisible(false);
	}

	private final void tableauImageInventaire() {
		this.tableauImage[0]= new Image("jeu/image/inventaire/epeeInventaire.png");
		this.tableauImage[1]= new Image("jeu/image/inventaire/piocheInventaire.png");
		this.tableauImage[2]= new Image("jeu/image/inventaire/hacheInventaire.png");
		this.tableauImage[3]= new Image("jeu/image/inventaire/pelleInventaire.png");
		this.tableauImage[4]= new Image("jeu/image/inventaire/piocheInventaire.png");
//		this.tableauImage[5]= new ImageView (new Image("jeu/image/inventaire/boisInventaire.png"));
//		this.tableauImage[6]= new ImageView (new Image("jeu/image/inventaire/charbonInventaire.png"));
		this.tableauImage[7]= new Image("jeu/image/BlocFer.png");
//		this.tableauImage[8]= new ImageView (new Image("jeu/image/inventaire/gazInventaire.png"));	
//		this.tableauImage[9]= new ImageView (new Image("jeu/image/inventaire/liquideTitanInventaire.png"));
//		this.tableauImage[10]= new ImageView (new Image("jeu/image/inventaire/painInventaire.png"));
//		this.tableauImage[11]= new ImageView (new Image("jeu/image/inventaire/potionTitanInventaire.png"));
		this.tableauImage[12]= new Image("jeu/image/4.png");
//		this.tableauImage[13]= new Image("jeu/image/inventaire/terreInventaire.png");
	}

	public void initialiserInventaire () {
		ImageView imgInventaire = null;
		for(int cases = 0; cases < 20 ; cases++) {
			imgInventaire = new ImageView(new Image("jeu/image/inventaire/caseInventaire.png"));
			this.afficherInventaire.getChildren().add(imgInventaire);
		}
	}
	
	public void afficherInventaire () {
		if (afficherInventaire.isVisible()) {
			afficherInventaire.setVisible(false);
			afficherObjet.setVisible(false);
		}
		else {
			afficherInventaire.setVisible(true);
			afficherObjet.setVisible(true);
		}
	}
	
	//affiche l'inventaire avec les objets qui sont dedans
	public void mettreAJourInventaire () {
		ImageView image;
		for (int i=0; i<this.inventaire.getInventaire().size(); i++) {
			int cas = this.inventaire.getInventaire().get(i).getIdObjet();
			switch (cas) {
			
			case 0:
				image = new ImageView(this.tableauImage[0]);
				break;
				
			case 1:
				image = new ImageView(this.tableauImage[1]);
				break;
			
			case 2:
				image = new ImageView(this.tableauImage[2]);
				break;
				
			case 3:
				image = new ImageView(this.tableauImage[3]);
				break;
				
			case 4:
				image = new ImageView(this.tableauImage[4]);
				break;
				
			case 5:
				image = new ImageView(this.tableauImage[5]);
				break;
				
			case 6:
				image = new ImageView(this.tableauImage[6]);
				break;
				
			case 7:
				image = new ImageView(this.tableauImage[7]);
				break;
				
			case 8:
				image = new ImageView(this.tableauImage[8]);
				break;
				
			case 9:
				image = new ImageView(this.tableauImage[9]);
				break;
				
			case 10:
				image = new ImageView(this.tableauImage[10]);
				break;
				
			case 11:
				image = new ImageView(this.tableauImage[11]);
				break;
				
			case 12:
				image = new ImageView(this.tableauImage[12]);
				break;
				
			default:
				image = null;
				break;
				
			}
			this.afficherObjet.getChildren().add(image);
			image.addEventHandler(MouseEvent.MOUSE_CLICKED, new MouseClickInventaire(this.inventaire.getInventaire().get(i),this.eren));
			this.afficherObjet.setVisible(false);
		}
	}

}