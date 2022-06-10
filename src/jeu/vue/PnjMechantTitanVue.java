package jeu.vue;

import javafx.collections.ListChangeListener;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import jeu.Parametre;
import jeu.controleur.MouseClickInventaire;
import jeu.controleur.MouseClickPnj;
import jeu.controleur.listener.InventaireListener;
import jeu.model.Environnement;
import jeu.model.Heros;
import jeu.model.PnjMechantTitan;
import jeu.model.inventaire.Objet;
import jeu.model.inventaire.arme.Arme;
import jeu.model.inventaire.arme.Epee;

public class PnjMechantTitanVue extends ImageView {

	
	private PnjMechantTitan pnj;
	private Image image = new Image("jeu/image/Reiner1.png");
	private Heros hero;
	private Pane PanePrincipale;
	private Environnement env;


	public PnjMechantTitanVue (PnjMechantTitan pnj ,Heros hero, Pane PanePrincipale ,Environnement env ) {			// initialisation de l'image et de ses coordoonées de base 
		this.pnj = pnj;
//		this.pnj.setX(200);
//		this.pnj.setY(360);
		this.setImage(image);
		this.addEventHandler(MouseEvent.MOUSE_CLICKED, new MouseClickPnj(pnj.getEnv(),this));
		this.hero = hero;
		setOnClickListener(); //appelle du listener
		this.env =env;
		this.PanePrincipale =PanePrincipale;
		//env.getListeTitans().addListener((ListChangeListener<? super PnjMechantTitan>) new ListetitansListener(this, pnj, env));

		//listener des pv qui retire le titan mort de la vue et du modele
		pnj.PvProperty().addListener((obs,old,newP) -> { 
			if(pnj.verificationMort() == true) {
				env.getListeTitans().remove(pnj);
				supprimerTitan();
				System.out.println(" \nJ'affiche je suis mort Titann!!!!!!!!!!");
			}
		});

	}

	public void affichageTitan(PnjMechantTitan pnj) {
		this.translateXProperty().bind(pnj.xProperty());	//la position du hero va être mise à jour en mm temps que la position du hero dans la vue
		this.translateYProperty().bind(pnj.yProperty());
		System.out.println("\n Affichage du x pnj" + xProperty());
//		changerImage();
	}
	
	/**
	 * agit en fonction du listener listeTitans quand un titan disparrait on le supprime son image
	 */
	public void supprimerTitan () {
			this.PanePrincipale.getChildren().remove(this);  // on supprime l'image associer
			System.out.println(" \nje passe dans la mort");
}


	
	private void setOnClickListener () {
	
		//Listener
		this.setOnMouseClicked(e -> {
			Objet objet = this.hero.getObjetHeros();

			int x =	(int) e.getX()*32;

			
			int y = (int) e.getY()*32;
			
			System.out.println("Coordonne titan X " + x);
			System.out.println("Coordonne titan Y " + y);
			
			System.out.println("Coordonne eren X " + env.getEren().getX());

			System.out.println("Coordonne eren Y " + env.getEren().getY());

			//(int coordonneeJoueurX, int coordonneeJoueurY, int positionBlocX, int positionBlocY ,int rangeX , int rangeY) {

			if(objet instanceof Epee && Parametre.rangeTitan(env.getEren().getX(),env.getEren().getY(), x, y, 100,100 )) {
				Arme arme = (Arme) objet;

				this.pnj.perdrePv(arme);
				System.out.println("\n Affichage pv titans " + this.pnj.PvProperty());
		
				arme.decrementerDurabiliteArme(arme);
				//this.supprimerTitan();
			}
		});
	}
}
