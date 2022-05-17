package jeu.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import org.omg.CORBA.Environment;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Circle;
import jeu.model.Environnement;
import jeu.model.Heros;
import jeu.model.Personnage;
import jeu.model.Terrain;
import jeu.vue.HerosVieVue;
import jeu.vue.PersonnageVue;
import jeu.vue.TerrainVue;

public class Controleur implements Initializable{

	private Heros hero;

	@FXML
	private TilePane tuilesFond;
	@FXML
	private BorderPane BorderPaneId;


	@Override
	public void initialize(URL location, ResourceBundle resources) {



		Environnement env = new Environnement();
		// juste new environnement
		TerrainVue terrainVue = new TerrainVue(tuilesFond, env.getTerrain());	//crée le terrain vue
		//Personnage hero = new Hero ();

		terrainVue.dessinerTerrain();

		hero = new Heros(0, 0, env.getTerrain());
		PersonnageVue pers1= new PersonnageVue(hero);
		this.BorderPaneId.getChildren().add(pers1);


		BorderPaneId.addEventHandler(KeyEvent.KEY_PRESSED,new KeyPressed(hero));	//pour savoir les touches qui sont appuyés
		BorderPaneId.addEventHandler(KeyEvent.KEY_RELEASED,new KeyPressed(hero) );	//pour savoir les touches qui sont relachés
		
		
		////////////
		HerosVieVue viehero = new HerosVieVue(hero, tuilesFond);
		this.BorderPaneId.getChildren().add(viehero);
		


		BorderPaneId.addEventHandler(KeyEvent.KEY_PRESSED,new KeyPressed(hero));	//pour savoir les touches qui sont appuyés
		BorderPaneId.addEventHandler(KeyEvent.KEY_RELEASED,new KeyPressed(hero) );	//pour savoir les touches qui sont relachés
		viehero.affichageVie(0);
	}
	
}









