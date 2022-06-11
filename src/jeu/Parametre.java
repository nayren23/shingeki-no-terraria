package jeu;

public class Parametre {

	//---------------------------------------------------------------------------------------//

	//Parametre utilise pour la direction avec une enumeration
	public static enum DIRECTION {
		RIGHT, LEFT, BOTTOM, TOP, SPACE;
	} 
	
	//---------------------------------------------------------------------------------------//
	
	//Ici c'est quand on casse le bloc il sera remplacer par le loc choisit en bas

	//Parametre du Terrain
	public static int tailleTuile = 32;

	public static int longueurTerrain = 40;

	//---------------------------------------------------------------------------------------//

	//Parametre du Heros 
	public static int vitessePersonnage = 3;

	public static int hauteurSautPersonnage = 7;

	public static int forceGravite = 3;

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
			System.out.println("\n tu peux  creuser frerot !!!");

		}
		else
			System.out.println("\n tu peux pas creuser frerot !!!");
		return peutCreuser;
	}
	
	//---------------------------------------------------------------------------------------//
	
	//   Parametre Titan

	public  static  int rechargeAttaqueTitans = 0;  	//recharge du titan initialiser a 0

	public  static  int rechargeAttaqueTitansTemps = 60; 

	public static int porteeCoupDuTitanX = 50;

	public static int porteeCoupDuTitanY = 10;

	public 	static	int vitesseTitan =2;

	public static int nbTitansGenerer = 6;

	public static int rangeAttaqueErenSurTitanX = 60; 

	public static int rangeAttaqueErenSurTitanY = 10; 

	//---------------------------------------------------------------------------------------//

	//Parametre de ou a ou le titan peut se deplacer
	public static int coordonneeMinTerrainTitanGauche =320;

	public static int coordonneeMaxTerrainTitanDroite =1052;

	public static int coordonneeTerrainTitanY =450;


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
			//			System.out.println("\n tu peux  le tuer frerot !!!");
		}
		else {
			//			System.out.println("\n tu peux pas le tuer frerot !!!");
		}
		return peutCreuser;
	}



}