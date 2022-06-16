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
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
import jeu.Parametre;
import jeu.model.Environnement;
import jeu.vue.HeroVue;
import jeu.model.inventaire.arme.Epee;
import jeu.model.inventaire.outil.Pelle;
import jeu.model.inventaire.outil.Pioche;
import jeu.model.inventaire.ressource.Pain;
import jeu.vue.HerosVieVue;
import jeu.vue.PnjMechantTitanVue;
import jeu.vue.SoundEffect;
import jeu.vue.TerrainVue;
import jeu.vue.inventaire.InventaireVue;

public class Controleur implements Initializable{

	private Timeline gameLoop;
	private Environnement env;
	private HeroVue hero1;

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
	private Button exit;

	@FXML
	private Pane panePause;

    @FXML
    private Label pause;

    @FXML
    private Button boutonRestart;

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
    	initialize(null, null);
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		gameLoop = new Timeline();

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

		//Creation de l'environnement qui lui recupere le Terrain
		env = new Environnement();

		//------------------------------------------------------------//

		gameOver.setVisible(false);
		//Creeation de la vue de chaque titan present de la liste qu'on afiche ensuite sur l'ecran
		for(int i =0 ;i< env.getListeTitans().size() ;i++) {
			PnjMechantTitanVue  pnjTitanVue = new PnjMechantTitanVue(env.getListeTitans().get(i),env.getEren(),panePersoMap, env);
			this.panePersoMap.getChildren().add(pnjTitanVue);
			pnjTitanVue.affichageTitan(env.getListeTitans().get(i));
		}

		//------------------------------------------------------------//

		// Creation de la Vue du Terrain 
		TerrainVue terrainVue = new TerrainVue(tuilesFond, env.getTerrain());	//cree le terrain vue
		terrainVue.dessinerTerrain();

		//------------------------------------------------------------//

		//Creation de la Vue du hero eren puis ajout de celui ci dans le pane
		// pane different pour eren pour qu'on puisse voir son image quand il est mort 
		hero1 = new HeroVue(env.getEren(),gameOver,gameLoop);
		this.PanePrincipale.getChildren().add(hero1);
		hero1.affichageEren(env.getEren());

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

		Pain pain = new Pain();
		env.getEren().getInventaireHeros().ajouterDansInventaire(pain);

		Epee epee = new Epee();
		env.getEren().getInventaireHeros().ajouterDansInventaire(epee);

		//		System.out.println(inv.getInventaire().get(0).getIdObjet());
		//		System.out.println(inv.getInventaire().get(1).getIdObjet());
		//		System.out.println(inv.getInventaire());
		System.out.println("Affichage liste Titans" + env.getListeTitans());

		initAnimation();
		// demarre l'animation
		gameLoop.play();


//		Parametre.sonMapTitan.playSound();
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

					//	System.out.println(hero.getDirection());



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
					//					System.out.println(" \n J'affiches la liste" + env.getListeTitans());
				}
						));
		gameLoop.getKeyFrames().add(kf);
	}

}