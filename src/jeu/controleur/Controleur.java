package jeu.controleur;

import java.net.URL;
import java.util.ArrayList;
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
import jeu.model.PnjMechantTitan;
import jeu.model.inventaire.Inventaire;
import jeu.vue.HeroVue;
import jeu.model.inventaire.arme.Epee;
import jeu.model.inventaire.outil.Pelle;
import jeu.model.inventaire.outil.Pioche;
import jeu.model.inventaire.ressource.Fer;
import jeu.model.inventaire.ressource.Terre;
import jeu.vue.HerosVieVue;
import jeu.vue.PnjMechantTitanVue;
import jeu.vue.TerrainVue;
import jeu.vue.inventaire.InventaireVue;

public class Controleur implements Initializable{

	private Timeline gameLoop;
	private Environnement env;
	
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
		
		//for(int i =0 ;i< env.getTitans().length ;i++) {
		PnjMechantTitanVue  pnjTitanVue = new PnjMechantTitanVue(env.getTitans());
		this.PanePrincipale.getChildren().add(pnjTitanVue);
		pnjTitanVue.affichageTitan(env.getTitans());
		

	//	}

		TerrainVue terrainVue = new TerrainVue(tuilesFond, env.getTerrain());	//cree le terrain vue
		terrainVue.dessinerTerrain();
		
		//------------------------------------------------------------//
	
		//Creation de la Vue du hero eren puis ajout de celui ci dans le pane
		HeroVue hero1 = new HeroVue(env.getEren());
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
		BorderPaneId.addEventHandler(KeyEvent.KEY_PRESSED,new KeyPressed(env.getEren(), viehero, invVue)); //pour savoir les touches qui sont appuee
		BorderPaneId.addEventHandler(KeyEvent.KEY_RELEASED,new KeyReleased(env.getEren()));//pour savoir les touches qui sont relachee
	
		//------------------------------------------------------------//

		//Creation de l usage de la souris 
		BorderPaneId.addEventHandler(MouseEvent.MOUSE_CLICKED, new MouseClick(env,terrainVue)); //fait la distinction entre les differant click de la souris
		
		Pelle pelle = new Pelle(env);
		env.getEren().getInventaireHeros().ajouterDansInventaire(pelle);

		Pioche pioche = new Pioche(env);
		env.getEren().getInventaireHeros().ajouterDansInventaire(pioche);
		
		Epee epee = new Epee();
		env.getEren().getInventaireHeros().ajouterDansInventaire(epee);

//		System.out.println(inv.getInventaire().get(0).getIdObjet());
//		System.out.println(inv.getInventaire().get(1).getIdObjet());
//		System.out.println(inv.getInventaire());

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

//					System.out.println(env.getEren().getX()/30);
//					System.out.println(env.getEren().getY()/28);
					//System.out.println(hero.getY());
					//gravité

				//	System.out.println(hero.getDirection());

					env.getEren().gravite();
					env.getEren().move();
					env.getTitans().seDeplace();
				}
						));
		gameLoop.getKeyFrames().add(kf);
	}

}