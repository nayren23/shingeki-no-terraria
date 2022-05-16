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
import jeu.model.Heros;
import jeu.model.Personnage;
import jeu.model.Terrain;
import jeu.vue.PersonnageVue;
import jeu.vue.TerrainVue;

public class controleur implements Initializable{


	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		Terrain terrain = new Terrain();								//crée le terrain modèle
		TerrainVue terrainVue = new TerrainVue(tuilesFond, terrain);	//crée le terrain vue
		//Personnage hero = new Hero ();
		
		terrainVue.dessinerTerrain();
		Personnage hero = new Heros(0, 0, terrain);
		PersonnageVue pers1= new PersonnageVue(hero);
		this.BorderPaneId.getChildren().add(pers1);
		
		BorderPaneId.addEventHandler(KeyEvent.KEY_PRESSED,new KeyPressed(hero,pers1));	//pour savoir les touches qui sont appuyés
		BorderPaneId.addEventHandler(KeyEvent.KEY_RELEASED,new KeyPressed(hero, pers1) );	//pour savoir les touches qui sont relachés

	}

	@FXML
	private TilePane tuilesFond;
	@FXML
	private BorderPane BorderPaneId;

}









