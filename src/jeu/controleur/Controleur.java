package jeu.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
import jeu.model.Environnement;
import jeu.model.Heros;
import jeu.model.inventaire.Inventaire;
import jeu.vue.HeroVue;
import jeu.model.inventaire.arme.Epee;
import jeu.model.inventaire.arme.Pelle;
import jeu.model.inventaire.arme.Pioche;
import jeu.model.inventaire.ressource.Fer;
import jeu.model.inventaire.ressource.Terre;
import jeu.vue.HerosVieVue;
import jeu.vue.TerrainVue;
import jeu.vue.inventaire.InventaireVue;

public class Controleur implements Initializable{

	private Timeline gameLoop;
	private Heros hero;

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

		//Creation de l'environnement qui lui recupere le Terrain
		Environnement env = new Environnement();
		
		TerrainVue terrainVue = new TerrainVue(tuilesFond, env.getTerrain());	//cree le terrain vue
		terrainVue.dessinerTerrain();
		
		//------------------------------------------------------------//
	
		//Creation de l'inventaire 
		Inventaire inv = new Inventaire();

		//Creation de la Vue du hero eren puis ajout de celui ci dans le pane
		hero = new Heros(0, 0, env.getTerrain(), inv);
		HeroVue hero1 = new HeroVue(hero);
		this.PanePrincipale.getChildren().add(hero1);
		hero1.affichageEren(hero);
		
		HerosVieVue viehero = new HerosVieVue(hero, PanePrincipale);
		viehero.affichageVie(hero.PvProperty().getValue()); //affichage vie hero en haut droite
		
		
		//------------------------------------------------------------//
		
		//Creation  de la VUE de l inventaire
		InventaireVue invVue = new InventaireVue(inv, afficherInventaire, afficherObjet,hero);
		this.PanePrincipale.getChildren().add(invVue);
		
		//------------------------------------------------------------//

		//Creation de l usage du clavier
		BorderPaneId.addEventHandler(KeyEvent.KEY_PRESSED,new KeyPressed(hero, viehero, invVue)); //pour savoir les touches qui sont appuee
		BorderPaneId.addEventHandler(KeyEvent.KEY_RELEASED,new KeyReleased(hero));//pour savoir les touches qui sont relachee
	
		//------------------------------------------------------------//

		//Creation de l usage de la souris 
		BorderPaneId.addEventHandler(MouseEvent.MOUSE_CLICKED, new MouseClick(hero,env.getTerrain(),terrainVue)); //fait la distinction entre les differant click de la souris
		
		Pelle pelle = new Pelle();
		inv.ajouterDansInventaire(pelle);
		Epee epee = new Epee();
		inv.ajouterDansInventaire(epee);
		Terre terre = new Terre();
		inv.ajouterDansInventaire(terre);
		
		Fer fer = new Fer();
		inv.ajouterDansInventaire(fer);
		
		Pioche pioche = new Pioche();
		inv.ajouterDansInventaire(pioche);
		//------------------------------------------------------------//

		
		System.out.println(inv.getInventaire().get(0).getIdObjet());
		System.out.println(inv.getInventaire().get(1).getIdObjet());
		System.out.println(inv.getInventaire());

		initAnimation();
		// demarre l'animation
		//gameLoop.play();
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
					System.out.println("loop");

					System.out.println(hero.getY());
					//gravité


					System.out.println(hero.getDirection());

					hero.gravite();
					hero.move();
				}
						));
		gameLoop.getKeyFrames().add(kf);
	}

}