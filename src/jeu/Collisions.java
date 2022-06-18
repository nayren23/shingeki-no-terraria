package jeu;

import jeu.model.Environnement;

public class Collisions {

	

	public static int coordoonneTuile (int x,int y) {
		x = x / Parametre.tailleTuile;

		if (y > 0) {
			y = y / Parametre.tailleTuile;
		}
		else {
			y = -1;
		}

		return (x+(y+1)*Parametre.longueurTerrain);
	}

	public static void additionnerDirY(int nb ,int dirY) {
		dirY += nb;
	}

	public static boolean verificationDeCollisions (int x ,Environnement env) {
		return (x < 0 || env.getTerrain().getTabTerrain()[x] > 0);
	}


}
