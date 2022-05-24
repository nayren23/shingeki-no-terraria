package jeu.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import jeu.model.Terrain;

public class TerrainVue {
	
	//acces au terrain
	private TilePane tuilesFond;
	private Terrain terrain;
	private Image imageTerrain[];

	
	// On creer les images une seule fois 
	private void tableauImageTerrain() {
		this.imageTerrain = new Image[7] ;  // a changer en fonction du nombre de tuiles
		imageTerrain[0] = new Image("jeu/image/ciel.png");
		imageTerrain[1] =new Image("jeu/image/1.png");
		imageTerrain[2] = new Image("jeu/image/2.png");
		imageTerrain[3] = new Image("jeu/image/3.png");
		imageTerrain[4] = new Image("jeu/image/4.png");
		imageTerrain[5] = new Image("jeu/image/5.png");
		imageTerrain[6] = new Image("jeu/image/trou.png");
	}
	
	public TerrainVue(TilePane tuilesFond, Terrain terrain) {
		this.tuilesFond = tuilesFond;
		this.terrain=terrain;
		tableauImageTerrain();
	}
	

	
	public void dessinerTerrain () {
		//tuilesFond.setMaxSize(40*32, 23*32); // largeur * taille tuile hauteur * nb tuiles pour pas que la fenetre quand on l'agrandit change
		tuilesFond.getChildren().clear();
		ImageView images ;
		for(int cases = 0; cases < terrain.getTerrain().length ; cases++) {
			switch(terrain.getTerrain()[cases]) {
	            case 0 :
	            	images = new ImageView(imageTerrain[0]);
	                break;

	            case 1 :
	            	images = new ImageView(imageTerrain[1]);
	                break;
	                
	            case 2 :
	            	images = new ImageView(imageTerrain[2]);
	                break;
	                
	            case 3 :
	            	images = new ImageView(imageTerrain[3]);
	                break;
	                
	            case 4 :
	            	images = new ImageView(imageTerrain[4]);
	                break;
	                
	            case 5 :
	            	images = new ImageView(imageTerrain[5]);
	                break;
	                
	            case 6 :
	            	images = new ImageView(imageTerrain[6]);
	                break;

	            default : 
	            	images = null;
	                break;
	            }
			tuilesFond.getChildren().add(images); //afficher les coeurs
		}
	}
	
//	public void changementTuileMinage(int numéroTuile , Terrain terrain) {
//
//		System.out.println("\nhello"+numéroTuile);
//		
//		ImageView img = new ImageView();
//		System.out.println("\nbonjour"+ terrain.getTerrain()[numéroTuile]);
//			if(Terrain.listeBlocMinable().contains (terrain.getTerrain()[numéroTuile] )) {
//				Image nvImage = new  Image("jeu/image/trou.png");
//                img .setImage(nvImage); 
//			}
//			tuilesFond.getChildren().add(img);
//
//	}

}