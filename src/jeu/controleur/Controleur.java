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
import jeu.model.inventaire.Inventaire;
import jeu.vue.HerosVieVue;
import jeu.vue.PersonnageVue;
import jeu.vue.TerrainVue;
import jeu.vue.inventaire.InventaireVue;

public class Controleur implements Initializable{

	private Heros hero;

	@FXML
	private TilePane tuilesFond;
	@FXML
	private BorderPane BorderPaneId;

	@FXML
	private Pane PanePrincipale;
	
	@FXML
	private TilePane afficherInventaire;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {



		//Creation de l'environnement qui lui recupere le Terrain
		Environnement env = new Environnement();
		TerrainVue terrainVue = new TerrainVue(tuilesFond, env.getTerrain());	//cr�e le terrain vue
		terrainVue.dessinerTerrain();

		hero = new Heros(0, 0, env.getTerrain());
		PersonnageVue pers1= new PersonnageVue(hero);
		this.BorderPaneId.getChildren().add(pers1);

		HerosVieVue viehero = new HerosVieVue(hero, PanePrincipale);
		Inventaire inv = new Inventaire();
		InventaireVue invVue = new InventaireVue(inv, afficherInventaire);
		this.PanePrincipale.getChildren().add(invVue);
		
		BorderPaneId.addEventHandler(KeyEvent.KEY_PRESSED,new KeyPressed(hero, viehero, invVue));	//pour savoir les touches qui sont appuy�s
		BorderPaneId.addEventHandler(MouseEvent.MOUSE_CLICKED, new MouseClick(hero,env.getTerrain(),terrainVue)); 
		
		viehero.affichageVie(hero.PvProperty().getValue()); //affichage vie hero en haut droite

	}

}




