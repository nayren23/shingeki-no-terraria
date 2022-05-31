package jeu;

public class Parametre {
	
		public static enum DIRECTION {
			RIGHT, LEFT, BOTTOM, TOP, SPACE;
		} 
		
		//Ici c'est quand on casse le bloc il sera remplacer par le loc choisit en bas
        public static int changementDuBlocCasserPelle = 0; //a changer
        
        public static int changementDuBlocCasserPioche = 0; //a changer

        public static int changementDuBlocCasserHache = 0; //a changer

        public static final int changementDuBlocConstruit = 1; // final car pas senser chanegr
}
