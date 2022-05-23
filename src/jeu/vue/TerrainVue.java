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
			ImageView img = new ImageView();
			switch(terrain.getTerrain()[cases]) {

			case 58 :
				img.setImage(new Image("jeu/image/terre.png"));
				break;
			case 0 :
				img.setImage(new Image("jeu/image/ciel.png"));
				break;
				
			case 1 :
				img.setImage(new Image("jeu/image/1.png"));
				break;
				
			case 2 :
				img.setImage(new Image("jeu/image/2.png"));
				break;
				
			case 3 :
				img.setImage(new Image("jeu/image/3.png"));
				break;
				
			case 4 :
				img.setImage(new Image("jeu/image/4.png"));
				break;
				
			case 5 :
				img.setImage(new Image("jeu/image/5.png"));
				break;
				
			case 6 :
				img.setImage(new Image("jeu/image/6.png"));
				break;
				
			case 7 :
				img.setImage(new Image("jeu/image/7.png"));
				break;
				
			case 8 :
				img.setImage(new Image("jeu/image/8.png"));
				break;

			case 9 :
				img.setImage(new Image("jeu/image/9.png"));
				break;
				
			case 10 :
				img.setImage(new Image("jeu/image/10.png"));
				break;
				
			case 11 :
				img.setImage(new Image("jeu/image/11.png"));
				break;
				
			case 12 :
				img.setImage(new Image("jeu/image/12.png"));
				break;
				
			default : 
				img = null;
				break;
			}
			tuilesFond.getChildren().add(img);
		}
	}

}