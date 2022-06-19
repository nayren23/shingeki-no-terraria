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
import javafx.stage.Stage;
import javafx.util.Duration;
import jeu.Main;
import jeu.Parametre;
import jeu.model.Environnement;
import jeu.model.Heros;
import jeu.model.Terrain;
import jeu.model.inventaire.Inventaire;
import jeu.vue.HeroVue;
import jeu.model.inventaire.Objet;
import jeu.model.inventaire.arme.Epee;
import jeu.model.inventaire.arme.LanceFoudroyante;
import jeu.model.inventaire.outil.Hache;
import jeu.model.inventaire.outil.Hache;
import jeu.model.inventaire.outil.Pelle;
import jeu.model.inventaire.outil.Pioche;
import jeu.model.inventaire.ressource.Bois;
import jeu.model.inventaire.ressource.Charbon;
import jeu.model.inventaire.ressource.Fer;
import jeu.model.inventaire.ressource.Gaz;
import jeu.model.inventaire.ressource.Pain;
import jeu.model.inventaire.ressource.Terre;
import jeu.model.inventaire.ressource.Fer;
import jeu.model.inventaire.ressource.Terre;
import jeu.vue.HerosVieVue;
import jeu.vue.PnjGentilVue;
import jeu.vue.PnjMechantTitanVue;
import jeu.vue.SoundEffect;
import jeu.vue.TerrainVue;
import jeu.vue.lanceFoudroyanteVue;
import jeu.vue.inventaire.InventaireVue;

public class Controleur implements Initializable{

	private static final Stage Stage = new Stage();
	private Timeline gameLoop;
	private Environnement env;
	private HeroVue hero1;
	private int coordonneeMax;
	private TerrainVue terrainVue;
	private PnjGentilVue erwin;
	private PnjGentilVue armin;
	private PnjGentilVue sacha;
	private boolean apparitionTitan = true;
	private boolean apparitionErwin = true;
	private boolean apparitionArmin = true;
	private boolean apparitionSacha = true;
	private boolean bateauConstruit = false;
	

	private Image imageErwin;
	@FXML
	private TilePane tuilesFond;
	@FXML
	private Pane panePersoMap;	
	@FXML
	private BorderPane BorderPaneId;
	@FXML
	private Pane PanePrincipale;
	@FXML
	private TilePane afficherInventaire;

	@FXML
	private ImageView eren;
	@FXML
	private Pane gameOver;
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
	private Label qteBois;
	@FXML
	private Label qteCharbon;
	@FXML
	private Label qteFer;
	@FXML
	private Label qteTerre;
	@FXML
	private Button exit;
	@FXML
	private Pane panePause;
	@FXML
	private Label pause;
	@FXML
	private Button boutonRestart;
	@FXML
	private Label bois;
	@FXML
	private Label terre;
	@FXML
	private Label fer;
	@FXML
	private Label charbon;



	@FXML
	void construireRessource(ActionEvent event) {
		if (event.getSource()==construireBateau) {
			Bois bois = new Bois();
			if (this.env.getEren().getInventaireHeros().interactionArminSacha(bois)) {
//				this.construireBateau.setVisible(false);
				this.paneBateau.setVisible(false);
				this.bateauConstruit = true;
			}
			else {
				this.statutConstructionBateau.setText("PAS ASSEZ DE RESSOURCES");
				this.statutConstructionBateau.toFront();
			}
		}
		if (event.getSource()==echangerPain) {
			Terre terre = new Terre();
			if (this.env.getEren().getInventaireHeros().interactionArminSacha(terre)) {
				this.statutEchangePain.setText("Merci pour l'echange!");
				this.statutEchangePain.toFront();
			}
			else {
				this.statutEchangePain.setText("Vous n'avez pas assez de terre...");
				this.statutEchangePain.toFront();
			}
		}
	}




	@FXML
	void sortirJeu(ActionEvent event) {
		System.out.println("gateaux");

		//		gameLoop.pause();
		System.exit(0);  // pour sortir du programme
	}

	//quand partie perdue
	@FXML
	void restart(ActionEvent event) {
		System.out.println("Je relance le jeu");
		Main lancement = new Main();
		((Stage) ((Button) event.getSource()).getScene().getWindow()).close();// pour sortir du programme
		lancement.start(Stage );
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
			LanceFoudroyante lanceFoudroyante = new LanceFoudroyante(env.getEren().getX() , env.getEren().getY(), env);
			lanceFoudroyanteVue lanceVue = new lanceFoudroyanteVue(lanceFoudroyante,panePersoMap,env);
			this.panePersoMap.getChildren().add(lanceVue);
			lanceVue.affichageTitan(lanceFoudroyante);
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

		gameLoop = new Timeline();

		//------------------------------------------------------------//

		//on creer l image
		Image img = new Image("jeu/image/arriereplanSNK.jpg");

		//on creer un backgroundImage qui contient notre image
		BackgroundImage backImage = new BackgroundImage(img,BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);

		//Puis on creer un background qui contient notre Backgroundimage
		Background backGround = new Background(backImage);

		//Ensuite on ajoute notre background a notre borderpane principale
		BorderPaneId.setBackground(backGround);


		this.paneSacha.setVisible(false);
		this.statutEchangePain.setVisible(false);
		this.paneBateau.setVisible(false);
		this.statutConstructionBateau.setVisible(false);
		this.hboxEtabli.setVisible(false);
		this.statutConstruction.setVisible(false);
		this.qteBois.setVisible(true);
		this.qteBois.toFront();
		this.bois.toFront();
		this.bois.setVisible(true);
		this.qteCharbon.setVisible(true);
		this.qteCharbon.toFront();
		this.charbon.toFront();
		this.charbon.setVisible(true);
		this.qteFer.setVisible(true);
		this.qteFer.toFront();
		this.fer.toFront();
		this.fer.setVisible(true);
		this.qteTerre.setVisible(true);
		this.qteTerre.toFront();
		this.terre.toFront();
		this.terre.setVisible(true);

		//Creation de l'environnement qui lui recupere le Terrain
		env = new Environnement();

		terrainVue = new TerrainVue(tuilesFond, env.getTerrain());	//cree le terrain vue
		terrainVue.dessinerTerrain();

		gameOver.setVisible(false);
		//Creeation de la vue de chaque titan present de la liste qu'on afiche ensuite sur l'ecran



		//------------------------------------------------------------//

		//Creation de la Vue du hero eren puis ajout de celui ci dans le pane
		// pane different pour eren pour qu'on puisse voir son image quand il est mort 
		hero1 = new HeroVue(env.getEren(),gameOver,gameLoop);
		this.PanePrincipale.getChildren().add(hero1);
		hero1.affichageEren(env.getEren());


		imageErwin = new Image("jeu/image/erwin.png");
		this.erwin = new PnjGentilVue(imageErwin, 50, 407);
		this.panePersoMap.getChildren().add(erwin);
		this.erwin.setVisible(false);
		this.erwin.setOnMouseClicked(mouseEvent -> {
			this.hboxEtabli.setVisible(!this.hboxEtabli.isVisible());
			this.statutConstruction.setVisible(!this.statutConstruction.isVisible());
			this.panePersoMap.requestFocus();
		});

		Image imageArmin = new Image("jeu/image/armin.png");
		this.armin = new PnjGentilVue(imageArmin,50, 407);
		this.panePersoMap.getChildren().add(armin);
		this.armin.setVisible(false);
		this.armin.setOnMouseClicked(mouseEvent -> {
			this.paneBateau.setVisible(!this.paneBateau.isVisible());
			this.statutConstructionBateau.setVisible(!this.statutConstructionBateau.isVisible());
			this.panePersoMap.requestFocus();
		});

		Image imageSacha = new Image("jeu/image/sacha.png");
		this.sacha = new PnjGentilVue(imageSacha,103,435);
		this.panePersoMap.getChildren().add(sacha);
		this.sacha.setVisible(false);
		this.sacha.setOnMouseClicked(mouseEvent -> {
			this.paneSacha.setVisible(!this.paneSacha.isVisible());
			this.statutEchangePain.setVisible(!this.statutEchangePain.isVisible());
			this.panePersoMap.requestFocus();
		});

		HerosVieVue viehero = new HerosVieVue(env.getEren(), panePersoMap);
		viehero.affichageVie(env.getEren().PvProperty().getValue()); //affichage vie hero en haut droite



		//------------------------------------------------------------//

		//Creation  de la VUE de l inventaire
		InventaireVue invVue = new InventaireVue(env,afficherInventaire, afficherObjet);
		this.panePersoMap.getChildren().add(invVue);

		//------------------------------------------------------------//
		panePause.setVisible(false);
		//Creation de l usage du clavier

		BorderPaneId.addEventHandler(KeyEvent.KEY_PRESSED,new KeyPressed(env.getEren(), viehero, invVue, hero1,panePause,gameLoop)); //pour savoir les touches qui sont appuee
		BorderPaneId.addEventHandler(KeyEvent.KEY_RELEASED,new KeyReleased(env.getEren()));//pour savoir les touches qui sont relachee

		//------------------------------------------------------------//

		//Creation de l usage de la souris 
		BorderPaneId.addEventHandler(MouseEvent.MOUSE_CLICKED, new MouseClick(env,terrainVue)); //fait la distinction entre les differant click de la souris

		Pelle pelle = new Pelle(env);
		env.getEren().getInventaireHeros().ajouterDansInventaire(pelle);

		Pioche pioche = new Pioche(env);
		env.getEren().getInventaireHeros().ajouterDansInventaire(pioche);

		Hache hache = new Hache(env);
		env.getEren().getInventaireHeros().ajouterDansInventaire(hache);
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
		bois.incrementerRessource();
		bois.incrementerRessource();
		bois.incrementerRessource();
		bois.incrementerRessource();
		bois.incrementerRessource();
		bois.incrementerRessource();
		bois.incrementerRessource();
		bois.incrementerRessource();
		bois.incrementerRessource();
		bois.incrementerRessource();
		bois.incrementerRessource();
		bois.incrementerRessource();
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

		gameLoop.setCycleCount(Timeline.INDEFINITE);

		KeyFrame kf = new KeyFrame(
				// on définit le FPS (nbre de frame par seconde)
				Duration.seconds(0.017), 
				// on définit ce qui se passe à chaque frame 
				// c'est un eventHandler d'ou le lambda
				(ev -> {

					//										System.out.println(" x d'eren" + Math.abs(env.getEren().getX()/30));
					//										System.out.println(" y d'eren" + Math.abs(env.getEren().getY()/30));
					//										int test = ((env.getEren().getY()/30)*40) + ((env.getEren().getX()/30)+1);
					//										System.out.println("tuile nm : " + test);

					//										System.out.println(" x d'eren" + Math.abs(env.getEren().getX()));
					//										System.out.println(" y d'eren" + Math.abs(env.getEren().getY()));
					hero1.animations(env.getEren());



					//					System.out.println(env.getEren().getX());
					//					System.out.println(env.getEren().getY());
					env.getEren().collisions();
					env.getEren().gravite();
					env.getEren().move();
					env.getEren().collisionDuBas(env.getEren().getX(), env.getEren().getY());

					if(!env.getEren().collisionDuBas(env.getEren().getX(), env.getEren().getY())){
						if(env.getEren().getDirY() < 10) {
							env.getEren().additionnerDirY(1);
						}
					}

					for(int i = 0; i < env.getEren().getInventaireHeros().getInventaire().size(); i++) {
						if(env.getEren().getInventaireHeros().getInventaire().get(i) instanceof Bois ) {
							this.bois.setText(env.getEren().getInventaireHeros().getInventaire().get(i) + "");
						}
						else if(env.getEren().getInventaireHeros().getInventaire().get(i) instanceof Terre ) {
							this.terre.setText(env.getEren().getInventaireHeros().getInventaire().get(i) + "");
						}
						else if(env.getEren().getInventaireHeros().getInventaire().get(i) instanceof Fer ) {
							this.fer.setText(env.getEren().getInventaireHeros().getInventaire().get(i) + "");
						}
						else if(env.getEren().getInventaireHeros().getInventaire().get(i) instanceof Charbon ) {
							this.charbon.setText(env.getEren().getInventaireHeros().getInventaire().get(i) + "");
						}
					}


					//pnj premiere map 
					if(apparitionErwin && env.getTerrain().parcourrirTab(env.getTerrain().getTabTerrain(),env.getTerrain().getVerifMap().get("2")) ) {
						erwin.setVisible(true);

					}
					else if(!env.getTerrain().parcourrirTab(env.getTerrain().getTabTerrain(),env.getTerrain().getVerifMap().get("2"))) {
						erwin.setVisible(false);
					}


					//pnj deuxieme map 
					if(apparitionArmin && env.getTerrain().parcourrirTab(env.getTerrain().getTabTerrain(),env.getTerrain().getVerifMap().get("3")) ) {
						armin.setVisible(true);

					}
					else if(!env.getTerrain().parcourrirTab(env.getTerrain().getTabTerrain(),env.getTerrain().getVerifMap().get("3"))) {
						armin.setVisible(false);
					}




					//pnj premiere map 
					if(apparitionSacha && env.getTerrain().parcourrirTab(env.getTerrain().getTabTerrain(),env.getTerrain().getVerifMap().get("5")) ) {
						sacha.setVisible(true);

					}
					else if(!env.getTerrain().parcourrirTab(env.getTerrain().getTabTerrain(),env.getTerrain().getVerifMap().get("5"))) {
						sacha.setVisible(false);
					}
					//transition map 1 -> 2
					if(env.getEren().getX() >= 1257 && env.getTerrain().parcourrirTab(env.getTerrain().getTabTerrain(),env.getTerrain().getVerifMap().get("1"))) {

						//						coordonneeMax = 1257;
						env.getEren().setX(10);
						env.getEren().setY(415);

						env.getTerrain().changerTerrain(env.getTerrain().getTabTerrain2());
						terrainVue = new TerrainVue(tuilesFond, env.getTerrain());	
						terrainVue.dessinerTerrain();

					}



					//transition map 2 -> 3
					if(env.getEren().getX() >= 1257 && env.getTerrain().parcourrirTab(env.getTerrain().getTabTerrain(),env.getTerrain().getVerifMap().get("2"))) {
						env.getEren().setX(10);
						env.getEren().setY(447);
						env.getTerrain().changerTerrain(env.getTerrain().getTabTerrain3());
						terrainVue = new TerrainVue(tuilesFond, env.getTerrain());	
						terrainVue.dessinerTerrain();

					}

					//transition map 3 -> 4
					if(env.getTerrain().parcourrirTab(env.getTerrain().getTabTerrain(),env.getTerrain().getVerifMap().get("3")) && bateauConstruit) {

						env.getEren().setX(10);
						env.getEren().setY(447);
						env.getTerrain().changerTerrain(env.getTerrain().getTabTerrain4());
						terrainVue = new TerrainVue(tuilesFond, env.getTerrain());	
						terrainVue.dessinerTerrain();
						this.panePersoMap.requestFocus();

						bateauConstruit = false;


					}


					//transition map 4 -> 5
					if(env.getEren().getX() >= 1257 && env.getTerrain().parcourrirTab(env.getTerrain().getTabTerrain(),env.getTerrain().getVerifMap().get("4"))) {
						env.getEren().setX(10);
						env.getEren().setY(447);
						env.getTerrain().changerTerrain(env.getTerrain().getTabTerrain5());
						terrainVue = new TerrainVue(tuilesFond, env.getTerrain());	
						terrainVue.dessinerTerrain();

					}



					//transition map 2 -> 1
					if(env.getEren().getX() <= 0 && env.getTerrain().parcourrirTab(env.getTerrain().getTabTerrain(),env.getTerrain().getVerifMap().get("2"))) {
						System.out.println("je rentre dans la condition");
						

						env.getEren().setX(1257);
						env.getEren().setY(447);

						env.getTerrain().changerTerrain(env.getTerrain().getTabTerrain());
						terrainVue = new TerrainVue(tuilesFond, env.getTerrain());	
						terrainVue.dessinerTerrain();

					}


					//transition map 3 -> 2
					if(env.getEren().getX() <= 0 && env.getTerrain().parcourrirTab(env.getTerrain().getTabTerrain(),env.getTerrain().getVerifMap().get("3"))) {
						env.getEren().setX(1257);
						env.getEren().setY(447);
						env.getTerrain().changerTerrain(env.getTerrain().getTabTerrain2());
						terrainVue = new TerrainVue(tuilesFond, env.getTerrain());	
						terrainVue.dessinerTerrain();

					}

					//transition map 4 -> 3
					if(env.getEren().getX() <= 0 && env.getTerrain().parcourrirTab(env.getTerrain().getTabTerrain(),env.getTerrain().getVerifMap().get("4"))) {
						env.getEren().setX(1257);
						env.getEren().setY(479);
						env.getTerrain().changerTerrain(env.getTerrain().getTabTerrain3());
						terrainVue = new TerrainVue(tuilesFond, env.getTerrain());	
						terrainVue.dessinerTerrain();

					}

					//transition map 5 -> 4

					if(env.getEren().getX() <= 0 && env.getTerrain().parcourrirTab(env.getTerrain().getTabTerrain(),env.getTerrain().getVerifMap().get("5"))) {
						env.getEren().setX(10);
						env.getEren().setY(447);
						env.getTerrain().changerTerrain(env.getTerrain().getTabTerrain5());
						terrainVue = new TerrainVue(tuilesFond, env.getTerrain());	
						terrainVue.dessinerTerrain();

					}


					//apparition des titans dans l'arene qui est sur la map 4
					if(apparitionTitan && env.getTerrain().parcourrirTab(env.getTerrain().getTabTerrain(),env.getTerrain().getVerifMap().get("5")) ) {
						apparitionTitan = false;
						env.creationListeTitans();
						for(int i =0 ;i< env.getListeTitans().size() ;i++) {
							PnjMechantTitanVue  pnjTitanVue = new PnjMechantTitanVue(env.getListeTitans().get(i),env.getEren(),panePersoMap, env);
							this.panePersoMap.getChildren().add(pnjTitanVue);
							pnjTitanVue.affichageTitan(env.getListeTitans().get(i));
						}



					}
					for(int i =0 ; i<env.getListeTitans().size() ; i++) {						
						env.getListeTitans().get(i).collisions();
						env.getListeTitans().get(i).gravite();
						env.getListeTitans().get(i).move();
//						System.out.println("\nregarde je bouge");
						env.getListeTitans().get(i).verificationMort();
					}
					Objet objet = this.env.getEren().getObjetHeros();
					if(objet instanceof LanceFoudroyante ) {
						LanceFoudroyante arme = (LanceFoudroyante) objet;

						if (arme.isLanceAvance() ==true) {
							arme.estMort();

						}
					}

				}
						));
		gameLoop.getKeyFrames().add(kf);

	}
}