package jeu.controleur;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
import jeu.model.Environnement;
import jeu.vue.HeroVue;
import jeu.model.inventaire.arme.Epee;
import jeu.model.inventaire.arme.LanceFoudroyante;
import jeu.model.inventaire.outil.Hache;
import jeu.model.inventaire.outil.Pelle;
import jeu.model.inventaire.outil.Pioche;
import jeu.model.inventaire.ressource.Bois;
import jeu.model.inventaire.ressource.Fer;
import jeu.model.inventaire.ressource.Gaz;
import jeu.model.inventaire.ressource.Pain;
import jeu.model.inventaire.ressource.Terre;
import jeu.vue.HerosVieVue;
import jeu.vue.PnjGentilVue;
import jeu.vue.PnjMechantTitanVue;
import jeu.vue.TerrainVue;
import jeu.vue.inventaire.InventaireVue;

public class Controleur implements Initializable{

	private Timeline gameLoop;
	private Environnement env;
	private HeroVue hero1;
	private PnjGentilVue erwin;
	private PnjGentilVue armin;
	private PnjGentilVue sacha;

	@FXML
	private TilePane tuilesFond;
	@FXML
	private BorderPane BorderPaneId;
	@FXML
	private Pane PanePrincipale;
	@FXML
	private TilePane afficherInventaire;
	@FXML
	private ImageView eren;
	@FXML
	private TilePane afficherObjet;
	@FXML
	private Label statutConstruction;
	@FXML
	private HBox hboxEtabli;
	@FXML
	private Button construirePelle;
	@FXML
	private Button construirePioche;
	@FXML
	private Button construireHache;
	@FXML
	private Button construireEpee;
	@FXML
    private Button construireLanceFoudroyante;
	@FXML
    private Pane paneBateau;
    @FXML
    private Button construireBateau;
    @FXML
    private Label statutConstructionBateau;
    @FXML
    private Pane paneSacha;
    @FXML
    private Button echangerPain;
    @FXML
    private Label statutEchangePain;
    
    @FXML
    void construireRessource(ActionEvent event) {
    	if (event.getSource()==construireBateau) {
    		Bois bois = new Bois();
    		if (this.env.getEren().getInventaireHeros().interactionArminSacha(bois)) {
				this.statutConstructionBateau.setText("CONSTRUIT");
				this.statutConstructionBateau.toFront();
    		}
    		else {
				this.statutConstructionBateau.setText("PAS ASSEZ DE RESSOURCES");
				this.statutConstructionBateau.toFront();
			}
    	}
    	if (event.getSource()==echangerPain) {
    		Terre terre = new Terre();
    		if (this.env.getEren().getInventaireHeros().interactionArminSacha(terre)) {
    			this.statutEchangePain.setText("Merci pour l'échange!");
    			this.statutEchangePain.toFront();
    		}
    		else {
    			this.statutEchangePain.setText("Vous n'avez pas assez de terre...");
    			this.statutEchangePain.toFront();
    		}
    	}
    }

	@FXML
	void construire(ActionEvent event) {
		Bois bois = new Bois();
		Fer fer = new Fer();
		if (event.getSource()==construirePelle) {
			Pelle pelle = new Pelle(env);
			if (this.env.getEren().getInventaireHeros().constructionErwin(pelle, bois, fer)) {
				this.statutConstruction.setText("CONSTRUIT");
				this.statutConstruction.toFront();
			}
			else {
				this.statutConstruction.setText("PAS ASSEZ DE RESSOURCES");
				this.statutConstruction.toFront();
			}
		}
		else if (event.getSource()==construirePioche) {
			Pioche pioche = new Pioche(env);
			if(this.env.getEren().getInventaireHeros().constructionErwin(pioche, bois, fer)){
				this.statutConstruction.setText("CONSTRUIT");
				this.statutConstruction.toFront();
			}
			else {
				this.statutConstruction.setText("PAS ASSEZ DE RESSOURCES");
				this.statutConstruction.toFront();
			}
		}
		else if (event.getSource()==construireHache) {
			Hache hache = new Hache(env);
			if(this.env.getEren().getInventaireHeros().constructionErwin(hache, bois, fer)) {
				this.statutConstruction.setText("CONSTRUIT");
				this.statutConstruction.toFront();
			}
			else {
				this.statutConstruction.setText("PAS ASSEZ DE RESSOURCES");
				this.statutConstruction.toFront();
			}
		}
		else if (event.getSource()==construireEpee) {
			Epee epee = new Epee();
			if(this.env.getEren().getInventaireHeros().constructionErwin(epee, bois, fer)){
				this.statutConstruction.setText("CONSTRUIT");
				this.statutConstruction.toFront();
			}
			else {
				this.statutConstruction.setText("PAS ASSEZ DE RESSOURCES");
				this.statutConstruction.toFront();
			}
		}
		else if (event.getSource()==construireLanceFoudroyante) {
			LanceFoudroyante lanceFoudroyante = new LanceFoudroyante();
			Gaz gaz = new Gaz();
			if(this.env.getEren().getInventaireHeros().constructionErwin(lanceFoudroyante, gaz, fer)){
				this.statutConstruction.setText("CONSTRUIT");
				this.statutConstruction.toFront();
			}
			else {
				this.statutConstruction.setText("PAS ASSEZ DE RESSOURCES");
				this.statutConstruction.toFront();
			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {


		//------------------------------------------------------------//

		// Ajout d une image de fon dans le BorderPane
		//on creer l image
		Image img = new Image("jeu/image/titanSNK.jpg"); //arriereplanSNK.jpg

		//on creer un backgroundImage qui contient notre image
		BackgroundImage backImage = new BackgroundImage(img,BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);

		//Puis on creer un background qui contient notre Backgroundimage
		Background backGround = new Background(backImage);

		//Ensuite on ajoute notre background a notre borderpane principale
		BorderPaneId.setBackground(backGround);

		//------------------------------------------------------------//

		this.paneSacha.setVisible(false);
		this.statutEchangePain.setVisible(false);
		this.paneBateau.setVisible(false);
		this.statutConstructionBateau.setVisible(false);
		this.hboxEtabli.setVisible(false);
		this.statutConstruction.setVisible(false);

		//Creation de l'environnement qui lui recupere le Terrain
		env = new Environnement();

		//------------------------------------------------------------//

		//Creeation de la vue de chaque titan present de la liste qu'on afiche ensuite sur l'ecran
		for(int i =0 ;i< env.getListeTitans().size() ;i++) {
			PnjMechantTitanVue  pnjTitanVue = new PnjMechantTitanVue(env.getListeTitans().get(i),env.getEren(),PanePrincipale, env);
			this.PanePrincipale.getChildren().add(pnjTitanVue);
			pnjTitanVue.affichageTitan(env.getListeTitans().get(i));
		}

		//------------------------------------------------------------//

		// Creation de la Vue du Terrain 
		TerrainVue terrainVue = new TerrainVue(tuilesFond, env.getTerrain());	//cree le terrain vue
		terrainVue.dessinerTerrain();

		//------------------------------------------------------------//

		//Creation de la Vue du hero eren puis ajout de celui ci dans le pane
		hero1 = new HeroVue(env.getEren());
		this.PanePrincipale.getChildren().add(hero1);
		hero1.affichageEren(env.getEren());
		
		Image imageErwin = new Image("jeu/image/erwin.png");
		this.erwin = new  PnjGentilVue(imageErwin);
		this.PanePrincipale.getChildren().add(erwin);
		this.erwin.setOnMouseClicked(mouseEvent -> {
			this.hboxEtabli.setVisible(!this.hboxEtabli.isVisible());
			this.statutConstruction.setVisible(!this.statutConstruction.isVisible());
		this.PanePrincipale.requestFocus();
		});
		
//		Image imageArmin = new Image("jeu/image/armin.png");
//		this.armin = new PnjGentilVue(imageArmin);
//		this.PanePrincipale.getChildren().add(armin);
//		this.armin.setOnMouseClicked(mouseEvent -> {
//			this.paneBateau.setVisible(!this.paneBateau.isVisible());
//			this.statutConstructionBateau.setVisible(!this.statutConstructionBateau.isVisible());
//		this.PanePrincipale.requestFocus();
//		});
		
//		Image imageSacha = new Image("jeu/image/sacha.png");
//		this.sacha = new PnjGentilVue(imageSacha);
//		this.PanePrincipale.getChildren().add(sacha);
//		this.sacha.setOnMouseClicked(mouseEvent -> {
//			this.paneSacha.setVisible(!this.paneSacha.isVisible());
//			this.statutEchangePain.setVisible(!this.statutEchangePain.isVisible());
//			this.PanePrincipale.requestFocus();
//		});

		HerosVieVue viehero = new HerosVieVue(env.getEren(), PanePrincipale);
		viehero.affichageVie(env.getEren().PvProperty().getValue()); //affichage vie hero en haut droite

		//------------------------------------------------------------//

		//Creation  de la VUE de l inventaire
		InventaireVue invVue = new InventaireVue(env,afficherInventaire, afficherObjet);
		this.PanePrincipale.getChildren().add(invVue);

		//------------------------------------------------------------//

		//Creation de l usage du clavier
		BorderPaneId.addEventHandler(KeyEvent.KEY_PRESSED,new KeyPressed(env.getEren(), viehero, invVue, hero1)); //pour savoir les touches qui sont appuee
		BorderPaneId.addEventHandler(KeyEvent.KEY_RELEASED,new KeyReleased(env.getEren()));//pour savoir les touches qui sont relachee

		//------------------------------------------------------------//

		//Creation de l usage de la souris 
		BorderPaneId.addEventHandler(MouseEvent.MOUSE_CLICKED, new MouseClick(env,terrainVue)); //fait la distinction entre les differant click de la souris

		Pelle pelle = new Pelle(env);
		env.getEren().getInventaireHeros().ajouterDansInventaire(pelle);

		Pioche pioche = new Pioche(env);
		env.getEren().getInventaireHeros().ajouterDansInventaire(pioche);

		Pain pain = new Pain();
		env.getEren().getInventaireHeros().ajouterDansInventaire(pain);

		Epee epee = new Epee();
		env.getEren().getInventaireHeros().ajouterDansInventaire(epee);

		Fer fer = new Fer();
		fer.incrementerRessource();
		fer.incrementerRessource();
		fer.incrementerRessource();
		fer.incrementerRessource();
		fer.incrementerRessource();
		fer.incrementerRessource();
		fer.incrementerRessource();
		fer.incrementerRessource();
		fer.incrementerRessource();
		fer.incrementerRessource();
		fer.incrementerRessource();
		fer.incrementerRessource();
		fer.incrementerRessource();
		fer.incrementerRessource();
		env.getEren().getInventaireHeros().ajouterDansInventaire(fer);

		Bois bois = new Bois();
		bois.incrementerRessource();
		bois.incrementerRessource();
		bois.incrementerRessource();
		env.getEren().getInventaireHeros().ajouterDansInventaire(bois);
		
		Terre terre = new Terre();
		terre.incrementerRessource();
		terre.incrementerRessource();
		terre.incrementerRessource();
		terre.incrementerRessource();
		terre.incrementerRessource();
		terre.incrementerRessource();
		terre.incrementerRessource();
		terre.incrementerRessource();
		terre.incrementerRessource();
		terre.incrementerRessource();
		terre.incrementerRessource();
		terre.incrementerRessource();
		env.getEren().getInventaireHeros().ajouterDansInventaire(terre);
		
		Gaz gaz = new Gaz();
		gaz.incrementerRessource();
		gaz.incrementerRessource();
		gaz.incrementerRessource();
		gaz.incrementerRessource();
		gaz.incrementerRessource();
		env.getEren().getInventaireHeros().ajouterDansInventaire(gaz);

		initAnimation();
		// demarre l'animation
		gameLoop.play();
	}


	private void initAnimation() {
		gameLoop = new Timeline();

		gameLoop.setCycleCount(Timeline.INDEFINITE);

		KeyFrame kf = new KeyFrame(
				// on définit le FPS (nbre de frame par seconde)
				Duration.seconds(0.017), 
				// on définit ce qui se passe à chaque frame 
				// c'est un eventHandler d'ou le lambda
				(ev -> {

					env.getEren().collisions();
					env.getEren().gravite();
					env.getEren().move();
					env.getEren().collisionDuBas(env.getEren().getX(), env.getEren().getY());

					if(!env.getEren().collisionDuBas(env.getEren().getX(), env.getEren().getY())){
						if(env.getEren().getDirY() < 10) {
							env.getEren().additionnerDirY(1);
						}
					}








					// Boucle qui verifie en permanance la collission gravite si le titan est present dans la liste
					for(int i =0 ; i<env.getListeTitans().size() ; i++) {						
						env.getListeTitans().get(i).collisions();
						env.getListeTitans().get(i).gravite();
						env.getListeTitans().get(i).move();
						env.getListeTitans().get(i).verificationMort();
					}
				}
						));
		gameLoop.getKeyFrames().add(kf);
	}

}