package jeu.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import jeu.Parametre;
import jeu.controleur.MouseClickPnj;
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
		this.setImage(image);
		this.addEventHandler(MouseEvent.MOUSE_CLICKED, new MouseClickPnj(pnj.getEnv(),this));
		this.hero = hero;
		setOnClickListener(); //appelle du listener
		this.env =env;
		this.PanePrincipale =PanePrincipale;

		//listener des pv qui retire le titan mort de la vue et du modele
		pnj.PvProperty().addListener((obs,old,newP) -> { 
			if(pnj.verificationMort()) {
				env.getListeTitans().remove(pnj);
				supprimerTitan();
			}
		});

	}

	/**
	 * 
	 * @param bind les coordonne du pnj avec celle de son image
	 */
	public void affichageTitan(PnjMechantTitan pnj) {
		this.translateXProperty().bind(pnj.xProperty());	//la position du hero va être mise à jour en mm temps que la position du hero dans la vue
		this.translateYProperty().bind(pnj.yProperty());
		System.out.println("\n Affichage du x pnj" + xProperty());
		//		changerImage();
	}

	/**
	 * agit en fonction du listener listeTitans quand un titan disparrait du modele on supprime son image
	 */
	public void supprimerTitan () {
		this.PanePrincipale.getChildren().remove(this);  // on supprime l'image associer
	}


	/**
	 * des que on clique sur un titan verifie si on a l eppe et que si on se trouve a la bonne distance alors on peut l attaquer
	 */
	private void setOnClickListener () {

		//Listener
		this.setOnMouseClicked(e -> {
			Objet objet = this.hero.getObjetHeros();

			if(objet instanceof Epee && Parametre.rangeTitan(env.getEren().getX(),env.getEren().getY(), pnj.getX(), pnj.getY(), Parametre.rangeAttaqueErenSurTitanX,Parametre.rangeAttaqueErenSurTitanY )) {
				Arme arme = (Arme) objet;
				this.pnj.perdrePv(arme);
				arme.decrementerDurabiliteArme(arme);
			}
		});
	}
}
