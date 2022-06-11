package jeu.model;

public class HitBox {

	private int coordonneePersoX ;
	private int coordonneePersoY ;
	private int coordonneePersoXgauche ;
	private int coordonneePersoXdroit ;
	private int coordonneePersoHautY ;
	private int coordonneePersoBasY ;
	


	public HitBox(int coordonneePersoX, int coordonneePersoY, int coordonneePersoXgauche, int coordonneePersoXdroit,
			int coordonneePersoHautY, int coordonneePersoBasY) {

		this.coordonneePersoX = coordonneePersoX;
		this.coordonneePersoY = coordonneePersoY;
		this.coordonneePersoXgauche = coordonneePersoXgauche;
		this.coordonneePersoXdroit = coordonneePersoXdroit;
		this.coordonneePersoHautY = coordonneePersoHautY;
		this.coordonneePersoBasY = coordonneePersoBasY;
	}

	/**
	 * Definit la zone d impact
	 */
	public boolean calculHitBox () {
		boolean estDansZoneHitBox = false;

		if( (coordonneePersoX >= (coordonneePersoX - coordonneePersoXgauche))
				&& (coordonneePersoX <= (coordonneePersoX - coordonneePersoXdroit))
				&& (coordonneePersoY>= (coordonneePersoY - coordonneePersoHautY))
				&& (coordonneePersoY<= (coordonneePersoY - coordonneePersoBasY))

				) {
			estDansZoneHitBox = true;
			System.out.println("\n Je suis  dans la hitbox YESSSS");
		}
		else {
			System.out.println("\n Je suis pas dans la hitbox");
		}
		return estDansZoneHitBox;
	}
	
//	public void comparaisonHitBox (HitBox hitboxMechant) {
//		
//		
//		//avoir meme y  sino chercher
//		//
//		if( (coordonneePersoX >= (coordonneePersoX - coordonneePersoXgauche))
//				&& (coordonneePersoX <= (coordonneePersoX - coordonneePersoXdroit)){
//			
//		}
//	}


}
