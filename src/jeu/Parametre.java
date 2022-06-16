package jeu;

public class Parametre {
	
		public static enum DIRECTION {
			RIGHT, LEFT, BOTTOM, TOP, SPACE;
		} 
		
		//Ici c'est quand on casse le bloc il sera remplacer par le loc choisit en bas

        public static int changementDuBlocCasser = 0; //a changer

        public static int tailleTuile = 32;
        
        public static int longueurTerrain = 40;
        
        public static int vitessePersonnage = 3;
         
        public static int hauteurSautPersonnage = 12;
        
        public static int forceGravite = 2;
        
        public static int largeurPersonnage = 20;
        
        public static int hauteurPersonnage = 25;
        
        public static int diffBlocDessu = 32;

        public static final int blocTerre = 2; // Bloc de terre final car pas senser changé
        
        public static final int blocCharbon = 3; // Bloc de terre final car pas senser changé
        
        public static final int blocGaz = 4; // Bloc de terre final car pas senser changé
	
        public static final int blocFer = 5; // Bloc de terre final car pas senser changé
        
        public static final int blocBois = 6; // Bloc de bois final car pas senser changé

        //---------------------------------------------------------------------------------------//

}