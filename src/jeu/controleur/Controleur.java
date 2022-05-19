package jeu.controleur;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import jeu.model.Environnement;
import jeu.model.Heros;
import jeu.model.Personnage;
import jeu.model.Terrain;
import jeu.vue.HeroVue;
import jeu.vue.PersonnageVue;
import jeu.vue.TerrainVue;

public class Controleur implements Initializable{

	private Timeline gameLoop;
	private Heros hero;
	
	@FXML
	private Pane idPane;
	@FXML
	private TilePane tuilesFond;
	@FXML
	private BorderPane BorderPaneId;
	@FXML
	private ImageView eren;


	@Override
	public void initialize(URL location, ResourceBundle resources) {



		Environnement env = new Environnement();
		// juste new environnement
		TerrainVue terrainVue = new TerrainVue(tuilesFond, env.getTerrain());	//crée le terrain vue
		//Personnage hero = new Hero ();

		terrainVue.dessinerTerrain();
				
		hero = new Heros(0, 0, env.getTerrain());

		HeroVue hero1 = new HeroVue(hero);
		this.idPane.getChildren().add(hero1);
		hero1.affichageEren(hero);
		
		
		
//		PersonnageVue pers1= new PersonnageVue(hero);
//		this.BorderPaneId.getChildren().add(pers1);

		
		

		
		BorderPaneId.addEventHandler(KeyEvent.KEY_PRESSED,new KeyPressed(hero));	//pour savoir les touches qui sont appuyés
		BorderPaneId.addEventHandler(KeyEvent.KEY_RELEASED,new KeyReleased(hero));	//pour savoir les touches qui sont relachés



		
		
		initAnimation();
		//		// demarre l'animation
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
					System.out.println("loop");

					System.out.println(hero.getY());
					//gravité


					System.out.println(hero.getDirection());

					if(hero.getY() <= 185)  {
					
						this.hero.setY(hero.getY() + 1);

						if(hero.getDirection() == -1) {
							this.hero.setX(hero.getX() - 1);

						}
						else if (hero.getDirection() == 2){
							this.hero.setX(hero.getX() + 1);

						}
						else {
							
						}

					}


				}
						));


		gameLoop.getKeyFrames().add(kf);
	}

}









