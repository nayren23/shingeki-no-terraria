package jeu;

import javafx.scene.image.Image;

public class Parametre {
	
		public static enum DIRECTION {
			RIGHT, LEFT, BOTTOM, TOP, SPACE;
		} 
		
		//Ici c'est quand on casse le bloc il sera remplacer par le loc choisit en bas
        public static int changementDuBlocCasserPelle = 0; //a changer
        
        public static int changementDuBlocCasserPioche = 0; //a changer

        public static int changementDuBlocCasserHache = 0; //a changer

        public static final int changementDuBlocConstruit = 1; // final car pas senser chanegr
		//---------------------------------------------------------------------------------------//

		//Sp�cification de chaque image
		/*
		 * 		this.imageTerrain = new Image[7] ;  // a changer en fonction du nombre de tuiles
		0 = new Image("jeu/image/ciel.png");
		1 =new Image("jeu/image/1.png");
		2 = new Image("jeu/image/2.png");
		3 = new Image("jeu/image/3.png");
		4 = new Image("jeu/image/4.png");
		5 = new Image("jeu/image/5.png");
		6 = new Image("jeu/image/trou.png");
		 */
		
		//---------------------------------------------------------------------------------------//

}
