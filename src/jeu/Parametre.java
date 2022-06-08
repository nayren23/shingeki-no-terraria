package jeu;

public class Parametre {
	
		public static enum DIRECTION {
			RIGHT, LEFT, BOTTOM, TOP, SPACE;
		} 
		
		//Ici c'est quand on casse le bloc il sera remplacer par le loc choisit en bas


        public static int tailleTuile = 32;
        
        public static int longueurTerrain = 40;
        
        public static int vitessePersonnage = 3;
        
        public static int hauteurSautPersonnage = 7;
        
        public static int forceGravite = 3;
        

        
        public static int largeurPersonnage = 20;
        
        public static int hauteurPersonnage = 25;
        
        public static int diffBlocDessu = 32;
        
        
        public static int changementDuBlocCasser = 0; //a changer

        public static final int blocTerre = 2; // Bloc de terre final car pas senser chanegr
        
        public static final int blocCharbon = 3; // Bloc de terre final car pas senser chanegr
        
        public static final int blocGaz = 4; // Bloc de terre final car pas senser chanegr
	
        public static final int blocFer = 5; // Bloc de terre final car pas senser chanegr

        
        ///////////////////////////////////////////
     //   Parametre Titan
        //recharge du titan initialiser a 0
        public  static  int rechargeAttaqueTitans = 0; 
        
        public  static  int rechargeAttaqueTitansTemps = 60; 

        public static int porteeCoupDuTitan = 50;

        
        public 	static	int vitesseTitan =1;
        
        public static int nbTitansGenerer = 5;
        ///////////////////////////////////////////


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
		


}