package jeu;

import jeu.vue.SoundEffect;

public class Parametre {
	
		public static enum DIRECTION {
			RIGHT, LEFT, BOTTOM, TOP, SPACE;
		} 
		
		//Ici c'est quand on casse le bloc il sera remplacer par le loc choisit en bas


        public static int tailleTuile = 32;
        
        public static int longueurTerrain = 40;
        
  
	//---------------------------------------------------------------------------------------//

	//Parametre du Heros 
	public static int vitessePersonnage = 3;

    public static int hauteurSautPersonnage = 12;
    
    public static int forceGravite = 2;
    
    public static int largeurPersonnage = 20;
    
    public static int hauteurPersonnage = 25;
    
    public static int diffBlocDessu = 32;
    
	//---------------------------------------------------------------------------------------//

	//Parametre du minage
	public static int changementDuBlocCasser = 0; //a changer

	public static final int blocTerre = 2; // Bloc de terre final car pas senser chanegr

	public static final int blocCharbon = 3; // Bloc de terre final car pas senser chanegr

	public static final int blocGaz = 4; // Bloc de terre final car pas senser chanegr

	public static final int blocFer = 5; // Bloc de terre final car pas senser chanegr
	
    public static final int blocBois = 6; // Bloc de bois final car pas senser changé
     //---------------------------------------------------------------------------------------//
//   Parametre Titan

     public  static  int rechargeAttaqueTitans = 0;      //recharge du titan initialiser a 0

     public  static  int rechargeAttaqueTitansTemps = 60; 

     public static int porteeCoupDuTitanX = 50;

     public static int porteeCoupDuTitanY = 10;

     public static int vitesseTitan = 2;

     public static int nbTitansGenerer = 6;

     public static int rangeAttaqueErenSurTitanX = 60; 

     public static int rangeAttaqueErenSurTitanY = 10;

	//---------------------------------------------------------------------------------------//

	//Parametre de ou a ou le titan peut se deplacer
	public static int coordonneeMinTerrainTitanGauche = 325;

	public static int coordonneeMaxTerrainTitanDroite = 1030;

	public static int coordonneeTerrainTitanY = 450;
	//---------------------------------------------------------------------------------------//

	
	
	/**
	 *  Fonction pour le calcul de la range pour le minage on creer une sorte de hitbox au joueur 
	 *  pour qu il ne puisse faire les action de minage qu a une certaine distance autour de lui
	 * @param coordonneeJoueurX
	 * @param coordonneeJoueurY
	 * @param positionBlocX  au clic
	 * @param positionBlocY  au clic
	 * @param rangeGauche	
	 * @param rangeDroite
	 * @param rangeHaut
	 * @param rangeBas
	 * @return si le joeur peut effectuer l action shouaiter au alentour de lui
	 */
	public static boolean rangePourCasserBloc (int coordonneeJoueurX, int coordonneeJoueurY , int positionBlocX, int positionBlocY ,int rangeGauche , int rangeDroite , int rangeHaut ,int rangeBas ) {

		boolean peutCreuser = false;

		if( coordonneeJoueurX -rangeGauche <= positionBlocX  &&  coordonneeJoueurX + rangeDroite >=positionBlocX 
				&&  (coordonneeJoueurY -rangeHaut <= positionBlocY &&  coordonneeJoueurY + rangeBas >=positionBlocY) ) {
			peutCreuser = true;
		}
		return peutCreuser;
	}
	
 
	/**
	 * Fonction qui permet de savoir si le joueur se trouve a cote du titan pour qu'il puisse se battre 
	 * @param coordonneeJoueurX sur la fenetre de jeu
	 * @param coordonneeJoueurY sur la fenetre de jeu
	 * @param positionTitanX    sur la fenetre de jeu
	 * @param positionTitanY	sur la fenetre de jeu
	 * @param rangeErenX
	 * @param rangeErenY
	 * @return si le joeur peut effectuer l action shouaiter au alentour de lui
	 */
	public static boolean rangeTitan (int coordonneeJoueurX, int coordonneeJoueurY, int positionTitanX, int positionTitanY ,int rangeErenX , int rangeErenY) {

		boolean peutCreuser = false;

		if( (coordonneeJoueurX -rangeErenX <= positionTitanX  &&  coordonneeJoueurX + rangeErenX >=positionTitanX )
				&&  (coordonneeJoueurY -rangeErenY <= positionTitanY &&  coordonneeJoueurY + rangeErenY >=positionTitanY) ) {
			peutCreuser = true;
		}
		return peutCreuser;
	}

	//////////////////////SON
	
	public static SoundEffect sonMapTitan = new SoundEffect("jeu/sound/snkPrincipale.wav");
	public static SoundEffect sonGameOverFinaleTatakae = new SoundEffect("jeu/sound/tatakae.wav");
	public static SoundEffect sonAjoutObjetInventaire	 = new SoundEffect("jeu/sound/ajoutItem.wav");
	public static SoundEffect mortTitan	 = new SoundEffect("jeu/sound/mortTitan.wav");
	public static SoundEffect epee	 = new SoundEffect("jeu/sound/epee.wav");
	public static SoundEffect lanceFoudroyante	= new SoundEffect("jeu/sound/lanceFoudroyante.wav");
	public static SoundEffect win	= new SoundEffect("jeu/sound/musiqueWin.wav");
	public static SoundEffect musicmap1	= new SoundEffect("jeu/sound/musicmap1.wav");
	public static SoundEffect musicmap2	= new SoundEffect("jeu/sound/musicmap2.wav");
	public static SoundEffect musicmap3	= new SoundEffect("jeu/sound/musicmap3.wav");
	public static SoundEffect musicmap4	= new SoundEffect("jeu/sound/musicmap4.wav");

	//////////////////////// 
	
	public static int dimensionLanceHauteur = 32 ;
	public static int dimensionLanceLargeur= 32 ;

}