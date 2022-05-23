package jeu.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import jeu.model.Environnement;
import jeu.model.Heros;
import jeu.vue.HerosVieVue;
import jeu.vue.PersonnageVue;
import jeu.vue.TerrainVue;

public class Controleur implements Initializable{

	private Heros hero;

	@FXML
	private TilePane tuilesFond;
	@FXML
	private BorderPane BorderPaneId;

    @FXML
    private Pane PanePrincipale;
    
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

		HerosVieVue viehero = new HerosVieVue(hero, PanePrincipale);

		BorderPaneId.addEventHandler(KeyEvent.KEY_PRESSED,new KeyPressed(hero, viehero));	//pour savoir les touches qui sont appuyés
//		BorderPaneId.addEventHandler(KeyEvent.KEY_RELEASED,new KeyPressed(hero,viehero) );	//pour savoir les touches qui sont relachés enlever car sinon fait les actions 2 fois pour les pv
	//	BorderPaneId.addEventFilter(MouseEvent.MOUSE_ENTERED_TARGET, new MouseClick(hero,viehero));
		BorderPaneId.addEventHandler(MouseEvent.MOUSE_CLICKED, new MouseClick(hero,env.getTerrain(),terrainVue)); 

		////////////
		//this.BorderPaneId.getChildren().add(viehero);
		viehero.affichageVie(hero.PvProperty().getValue()); //affichage vie hero en haut droite
		
	}
	
}




