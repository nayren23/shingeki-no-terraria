package jeu.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import jeu.Parametre;
import jeu.model.Terrain;

public class TerrainVue {

	//acces au terrain
	private TilePane tuilesFond;
	private Terrain terrain;
	private Image imageTerrain[];
	

	/**
	 * Cette methodes crer une seul fois les images necessaire a l affichage du Terrain 
	 * et stocke les images dans un tableau d Images
	 */
	
	/* 
Bloc de Ciel Vide : 0
Bloc d�Herbes : 1
Bloc de Terre : 2
Bloc de Charbon : 3
Bloc de Gaz :  4
Bloc de Fer : 5
*/
	private void tableauImageTerrain() {
		this.imageTerrain = new Image[7] ;  // a changer en fonction du nombre de tuiles
		imageTerrain[0] = new Image("jeu/image/BlocTransparent.png");
		imageTerrain[1] =new Image("jeu/image/BlocHerbe.png");
		imageTerrain[2] = new Image("jeu/image/BlocTerre.png");
		imageTerrain[3] = new Image("jeu/image/BlocCharbon.png");
		imageTerrain[4] = new Image("jeu/image/BlocGaz.png");
		imageTerrain[5] = new Image("jeu/image/BlocFer.png");
		imageTerrain[6] = new Image("jeu/image/BlocBois.png");

	}

	/**
	 * 
	 * @param tuilesFond  Le TilePane au se trouve les Tuiles de la map
	 * @param terrain 		Terrain utilise pour la creation de la Vue de celui ci
	 */
	public TerrainVue(TilePane tuilesFond, Terrain terrain) {
		this.tuilesFond = tuilesFond;
		this.terrain=terrain;
		tableauImageTerrain();
	}


	/**
	 * On dessine le Terrain qu'une seul fois
	 */
	public void dessinerTerrain () {
		//tuilesFond.setMaxSize(40*32, 23*32); // largeur * taille tuile hauteur * nb tuiles pour pas que la fenetre quand on l'agrandit change
		tuilesFond.getChildren().clear(); // on clean le tilePane si jamais
		ImageView images ;
		
		for(int cases = 0; cases < terrain.getTabTerrain().length ; cases++) {
			switch(terrain.getTabTerrain()[cases]) {
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
				
			case 7 :
				images = new ImageView(imageTerrain[7]);
				break;

			default : 
				images = null;
				break;
			}
			tuilesFond.getChildren().add(images); //ajoute les images dans le tilePane
		}
	}
	
	/**
     * Cette méthode actualise seulement la case qui vient d etre modifier dans le modele
     * 
     * @param numéroTuile  qu'on soit modifier dans la Vue
     * @param terrain  dans quel terrain ce fait ce changement
     * 
     */
    public void changementTuileMinage(int numeroTuile , Terrain terrain, int blocChanger) {
        if(terrain.getTabTerrain()[numeroTuile] == blocChanger) {
            ImageView img = new ImageView();
            img.setImage(imageTerrain[blocChanger]); // utilisation des images qui sont dans le tableua créer une seul fois plus haut
            tuilesFond.getChildren().set(numeroTuile, img); // on change l'image a la position souhaiter par la nouvelle
        }
    }

}