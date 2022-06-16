package jeu.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
import jeu.model.Environnement;
import jeu.model.Heros;
import jeu.model.Terrain;
import jeu.model.inventaire.Inventaire;
import jeu.vue.HeroVue;
import jeu.model.inventaire.arme.Epee;
import jeu.model.inventaire.outil.Hache;
import jeu.model.inventaire.outil.Pelle;
import jeu.model.inventaire.outil.Pioche;
import jeu.model.inventaire.ressource.Fer;
import jeu.model.inventaire.ressource.Terre;
import jeu.vue.HerosVieVue;
import jeu.vue.TerrainVue;
import jeu.vue.inventaire.InventaireVue;

public class Controleur implements Initializable{

	private Timeline gameLoop;
	private Environnement env;
	private HeroVue hero1;
	private int coordonneeMax;
	private TerrainVue terrainVue;

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
	


	@Override
	public void initialize(URL location, ResourceBundle resources) {

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


		//Creation de l'environnement qui lui recupere le Terrain
		env = new Environnement();

		terrainVue = new TerrainVue(tuilesFond, env.getTerrain());	//cree le terrain vue
		terrainVue.dessinerTerrain();



		//------------------------------------------------------------//

		//Creation de la Vue du hero eren puis ajout de celui ci dans le pane
		hero1 = new HeroVue(env.getEren());
		this.PanePrincipale.getChildren().add(hero1);
		hero1.affichageEren(env.getEren());

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

		Hache hache = new Hache(env);
		env.getEren().getInventaireHeros().ajouterDansInventaire(hache);



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

					//										System.out.println(" x d'eren" + Math.abs(env.getEren().getX()/30));
					//										System.out.println(" y d'eren" + Math.abs(env.getEren().getY()/30));
					//										int test = ((env.getEren().getY()/30)*40) + ((env.getEren().getX()/30)+1);
					//										System.out.println("tuile nm : " + test);

					//										System.out.println(" x d'eren" + Math.abs(env.getEren().getX()));
					//										System.out.println(" y d'eren" + Math.abs(env.getEren().getY()));
					hero1.animations(env.getEren());


					System.out.println(env.getEren().getX());
					System.out.println(env.getEren().getY());
					env.getEren().collisions();
					env.getEren().gravite();
					env.getEren().move();
					env.getEren().collisionDuBas(env.getEren().getX(), env.getEren().getY());

					if(!env.getEren().collisionDuBas(env.getEren().getX(), env.getEren().getY())){
						if(env.getEren().getDirY() < 10) {
							env.getEren().additionnerDirY(1);
						}
					}

//					System.out.println( "verification des maps"+ env.getTerrain().getVerifMap());
//					//					System.out.println(env.getEren().getX());
//					System.out.println("la coordo  max " + coordonneeMax);
					
					
					

					System.out.println( "voici la comparaison  1 : "+ env.getTerrain().parcourrirTab(env.getTerrain().getTabTerrain(), env.getTerrain().getVerifMap().get("1")));
					System.out.println( "voici la comparaison  2 : "+ env.getTerrain().parcourrirTab(env.getTerrain().getTabTerrain(), env.getTerrain().getVerifMap().get("2")));
					System.out.println( "voici la comparaison  3 : "+ env.getTerrain().parcourrirTab(env.getTerrain().getTabTerrain(), env.getTerrain().getVerifMap().get("3")));

					//transition map2
					if(env.getEren().getX() >= 1257 && env.getTerrain().parcourrirTab(env.getTerrain().getTabTerrain(),env.getTerrain().getVerifMap().get("1"))) {

						//						coordonneeMax = 1257;
						env.getEren().setX(130);
						env.getEren().setY(415);

						env.getTerrain().changerTerrain(env.getTerrain().getTabTerrain2());
						terrainVue = new TerrainVue(tuilesFond, env.getTerrain());	
						terrainVue.dessinerTerrain();


					}
					
					
					
					//transition map3
					if(env.getEren().getX() >= 1257 && env.getTerrain().parcourrirTab(env.getTerrain().getTabTerrain(),env.getTerrain().getVerifMap().get("2"))) {

						System.out.println("addition " + (coordonneeMax + env.getEren().getX()));
						//if(env.getEren().getX() >= 2505) {


						env.getEren().setX(10);
						env.getEren().setY(447);
						env.getTerrain().changerTerrain(env.getTerrain().getTabTerrain3());
						terrainVue = new TerrainVue(tuilesFond, env.getTerrain());	
						terrainVue.dessinerTerrain();

					}
					
					
					
					
					if(env.getEren().getX() <= 0 && env.getTerrain().parcourrirTab(env.getTerrain().getTabTerrain(),env.getTerrain().getVerifMap().get("2"))) {
						System.out.println("je rentre dans la condition");


						env.getEren().setX(1257);
						env.getEren().setY(447);
						env.getTerrain().changerTerrain(env.getTerrain().getTabTerrain());
						terrainVue = new TerrainVue(tuilesFond, env.getTerrain());	
						terrainVue.dessinerTerrain();

					}
					
					
					if(env.getEren().getX() <= 0 && env.getTerrain().parcourrirTab(env.getTerrain().getTabTerrain(),env.getTerrain().getVerifMap().get("3"))) {
						
						env.getEren().setX(1257);
						env.getEren().setY(511);
						env.getTerrain().changerTerrain(env.getTerrain().getTabTerrain2());
						terrainVue = new TerrainVue(tuilesFond, env.getTerrain());	
						terrainVue.dessinerTerrain();

					}
					
					
					
					
					
			
				}
						));
		gameLoop.getKeyFrames().add(kf);
	}

}