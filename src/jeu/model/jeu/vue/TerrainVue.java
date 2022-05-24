package jeu.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import jeu.model.Terrain;

public class TerrainVue {
	
	//accès au terrain
	private TilePane tuilesFond;
	private Terrain terrain;
	
	public TerrainVue(TilePane tuilesFond, Terrain terrain) {
		this.tuilesFond = tuilesFond;
		this.terrain=terrain;
	}
	
	public void dessinerTerrain () {
		tuilesFond.getChildren().clear();
		for(int cases = 0; cases < terrain.getTerrain().length ; cases++) {
			ImageView img;
			switch(terrain.getTerrain()[cases]) {

			case 53 :
				img = new ImageView(new Image("jeu/image/ciel.png"));
				break;

			case 192 :
				img = new ImageView(new Image("jeu/image/terre.png"));
				break;

			default : 
				img = null;
				break;
			}
			tuilesFond.getChildren().add(img);
		}
	}

}
