package jeu.vue;

import javafx.scene.control.ProgressBar;
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
import jeu.model.inventaire.arme.LanceFoudroyante;

public class PnjMechantTitanVue extends ImageView {


	private PnjMechantTitan pnj;
	private Image image = new Image("jeu/image/Reiner1.png");
	private Heros hero;
	private Pane PanePrincipale;
	private Environnement env;
	private ProgressBar barreVie;

	double progress ;
	public PnjMechantTitanVue (PnjMechantTitan pnj ,Heros hero, Pane PanePrincipale ,Environnement env ) {			// initialisation de l'image et de ses coordoonées de base 
		this.pnj = pnj;
		this.setImage(image);
		this.addEventHandler(MouseEvent.MOUSE_CLICKED, new MouseClickPnj(pnj.getEnv(),this));
		this.hero = hero;
		setOnClickListener(); //appelle du listener
		this.env =env;
		this.PanePrincipale =PanePrincipale;
		this.barreVie = new ProgressBar();

		barreVie.setVisible(true);
		barreVie.setStyle("-fx-accent: #FF0000"); // on set la couleur sur rouge
		barreVie.setPrefSize(40, 10); // on choisit la taille de la barre de d�gat

		this.PanePrincipale.getChildren().add(barreVie);
		//		&& this.barreVie.getProgress()>=0.9
		//listener des pv qui retire le titan mort de la vue et du modele
		pnj.PvProperty().addListener((obs,old,newP) -> { 
			if(pnj.verificationMort() ) { // on regarde aussi si la barre de vie et complete
				env.getListeTitans().remove(pnj);
				supprimerTitan();
				this.PanePrincipale.getChildren().remove(this.barreVie);  // on supprime la barre de vie 
				Parametre.mortTitan.playSound();
				System.out.println("meurrrr");
			}

		});

		//Listener pour que la barre de vie bouge avec son Titan
		pnj.xProperty().addListener((obs,old,newP) -> {
			barreVie.setLayoutX(pnj.getX());
		});

		//Listener pour que la barre de vie bouge avec son Titan
		pnj.yProperty().addListener((obs,old,newP) -> {
			barreVie.setLayoutY(pnj.getY()-30);
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
			//			System.out.println("\npalalal");

			if(Parametre.rangeTitan(env.getEren().getX(),env.getEren().getY(), pnj.getX(), pnj.getY(), Parametre.rangeAttaqueErenSurTitanX,Parametre.rangeAttaqueErenSurTitanY )) {
				if(objet instanceof Epee ) {
					Arme arme = (Arme) objet;
					progress += 0.1;  //de combien eon incremente la barre de vie
					Parametre.epee.playSound();
					this.barreVie.setProgress(progress); //a chque coup le pnj prend  1 degat 
					this.pnj.perdrePv(arme);
					System.out.println("hp titan" + pnj.PvProperty().getValue());
					arme.decrementerDurabiliteArme(arme);
					System.out.println("\n barre vie" + this.barreVie.getProgress());

				}

			}
		});
	}
}
