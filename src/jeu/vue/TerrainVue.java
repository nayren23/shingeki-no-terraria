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

	            case 0 :
	                img = new ImageView(new Image("jeu/image/ciel.png"));
	                break;

	            case 1 :
	                img = new ImageView(new Image("jeu/image/1.png"));
	                break;
	            case 2 :
	                img = new ImageView(new Image("jeu/image/2.png"));
	                break;
	            case 3 :
	                img = new ImageView(new Image("jeu/image/3.png"));
	                break;
	            case 4 :
	                img = new ImageView(new Image("jeu/image/4.png"));
	                break;
	            case 5 :
	                img = new ImageView(new Image("jeu/image/5.png"));
	                break;
	            case 6 :
	                img = new ImageView(new Image("jeu/image/trou.png"));
	                break;

	            default : 
	                img = null;
	                break;
	            }
			
			tuilesFond.getChildren().add(img);
		}
	}

}
