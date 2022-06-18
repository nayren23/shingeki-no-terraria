package jeu.vue.inventaire;

import java.util.HashMap;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import jeu.controleur.MouseClickInventaire;
import jeu.controleur.listener.InventaireListener;
import jeu.model.Environnement;
import jeu.model.Heros;
import jeu.model.inventaire.Inventaire;
import jeu.model.inventaire.Objet;
import jeu.model.inventaire.arme.Epee;
import jeu.model.inventaire.arme.LanceFoudroyante;
import jeu.model.inventaire.outil.Hache;
import jeu.model.inventaire.outil.Pelle;
import jeu.model.inventaire.outil.Pioche;
import jeu.model.inventaire.ressource.Bois;
import jeu.model.inventaire.ressource.Charbon;
import jeu.model.inventaire.ressource.Fer;
import jeu.model.inventaire.ressource.Gaz;
import jeu.model.inventaire.ressource.LiquideTitan;
import jeu.model.inventaire.ressource.Pain;
import jeu.model.inventaire.ressource.PiqureTitan;
import jeu.model.inventaire.ressource.Terre;

public class InventaireVue extends Pane{

	private Environnement env;
	private TilePane afficherInventaire;
	private TilePane afficherObjet;
	private Image tableauImage[];
	private HashMap<Integer, ImageView> positionImageVue;

	public InventaireVue(Environnement env, TilePane inv, TilePane obj) {
		this.env = env;
		this.afficherInventaire=inv;
		this.getChildren().add(this.afficherInventaire);
		this.afficherObjet=obj;
		this.getChildren().add(this.afficherObjet);
		this.tableauImage = new Image [13];
		this.positionImageVue = new HashMap<>();
		new InventaireListener(this, env.getEren().getInventaireHeros());
		initialiserInventaire();
		tableauImageInventaire();
		this.afficherInventaire.setVisible(false);
	}

	private final void tableauImageInventaire() {
		this.tableauImage[0]= new Image("jeu/image/inventaire/epeeInventaire.png");
		this.tableauImage[1]= new Image("jeu/image/inventaire/hacheInventaire.png");
		this.tableauImage[2]= new Image("jeu/image/inventaire/lanceFoudroyanteInventaire.png");
		this.tableauImage[3]= new Image("jeu/image/inventaire/pelleInventaire.png");
		this.tableauImage[4]= new Image("jeu/image/inventaire/piocheInventaire.png");
		this.tableauImage[5]= new Image("jeu/image/inventaire/boisInventaire.png");
		this.tableauImage[6]= new Image("jeu/image/inventaire/charbonInventaire.png");
		this.tableauImage[7]= new Image("jeu/image/inventaire/ferInventaire.png");
		this.tableauImage[8]= new Image("jeu/image/inventaire/gazInventaire.png");	
		this.tableauImage[9]= new Image("jeu/image/inventaire/liquideTitanInventaire.png");
		this.tableauImage[10]= new Image("jeu/image/inventaire/painInventaire.png");
		this.tableauImage[11]= new Image("jeu/image/inventaire/piqureTitanInventaire.png");
		this.tableauImage[12]= new Image("jeu/image/inventaire/terreInventaire.png");
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
		int iteration = env.getEren().getInventaireHeros().getInventaire().size()-1;
		int cas = env.getEren().getInventaireHeros().getInventaire().get(iteration).getIdObjet();
		System.out.println("CAS = "+cas);
		switch (cas) {

		case 0:
			image = new ImageView(this.tableauImage[0]);
			image.setId("objet" + cas);
			break;

		case 1:
			image = new ImageView(this.tableauImage[1]);
			image.setId("objet" + cas);
			break;

		case 2:
			image = new ImageView(this.tableauImage[2]);
			image.setId("objet" + cas);
			break;

		case 3:
			image = new ImageView(this.tableauImage[3]);
			image.setId("objet" + cas);
			break;

		case 4:
			image = new ImageView(this.tableauImage[4]);
			image.setId("objet" + cas);
			break;

		case 5:
			image = new ImageView(this.tableauImage[5]);
			image.setId("objet" + cas);
			break;

		case 6:
			image = new ImageView(this.tableauImage[6]);
			image.setId("objet" + cas);
			break;

		case 7:
			image = new ImageView(this.tableauImage[7]);
			image.setId("objet" + cas);
			break;

		case 8:
			image = new ImageView(this.tableauImage[8]);
			image.setId("objet" + cas);
			break;

		case 9:
			image = new ImageView(this.tableauImage[9]);
			image.setId("objet" + cas);
			break;

		case 10:
			image = new ImageView(this.tableauImage[10]);
			image.setId("objet" + cas);
			break;

		case 11:
			image = new ImageView(this.tableauImage[11]);
			image.setId("objet" + cas);
			break;

		case 12:
			image = new ImageView(this.tableauImage[12]);
			image.setId("objet" + cas);
			break;

		default:
			System.out.println("DEFAULT");
			image = null;
			break;

		}
		this.afficherObjet.getChildren().add(image);
		this.positionImageVue.put(cas, image);
		image.addEventHandler(MouseEvent.MOUSE_CLICKED, new MouseClickInventaire(env.getEren().getInventaireHeros().getInventaire().get(iteration),env.getEren()));
		//this.afficherObjet.setVisible(false);
	}

	public void enleverObjet (Objet o) {
		this.afficherObjet.getChildren().remove(lookup("#objet" + o.getIdObjet())); //va chercher grace au lookup puis va remove a la bonne position
	}

}