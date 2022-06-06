package jeu.model;

public class Collisions {
	

	private Terrain t;
	
	
	public Collisions(Terrain t) {
		super();
		this.t = t;
	}
	
//
//	public boolean collisionsHaut() {
//
//		if(t.getTabTerrain()[x - 40] == 0 ) {
//			return true;
//		}
//		else {
//			return false;
//		}
//
//	}
//
	public boolean collisionsBas(int y, int x ) {

		System.out.println("tuile numeros : " + t.getTabTerrain()[(y/30)*40]);

		if(t.getTabTerrain()[((y/30)*40)] == 1){
			
			return true;
		}
		else {
			return false;
		}
	}
//
//	public boolean collisionsGauche() {
//		if(t.getTabTerrain()[x - 1] == 0 ) {
//			return true;
//		}
//		else {
//			return false;
//		}
//
//	}
//	public boolean collisionsDroite(int x, int y) {
//		if((t.getTabTerrain()[(y/30)*40 + (x/30)+1] == 1) || (t.getTabTerrain()[(y/30)*40 + (x/30)+1] == 2) ) {
//			System.out.println("tuile numeros : " + t.getTabTerrain()[(y/30)*40 + (x/30)+1]);
//			System.out.println("voici mon x " + x);
//			System.out.println("voici mon Y" +  y);
//			
//			return true;
//		}
//		else {
//			System.out.println("tuile numeros : " + t.getTabTerrain()[(y/30)*40 + (x/30)+1]);
//			System.out.println("voici mon x " + x);
//			System.out.println("voici mon Y" +  y);
//			return false;
//		}
//
//	}

}
