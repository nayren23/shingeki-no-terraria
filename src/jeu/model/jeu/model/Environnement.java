package jeu.model;

import java.util.ArrayList;

public class Environnement {
		//30*20
		private Terrain terrain;
		private int width, height;
		private ArrayList<Personnage> personnages;
		private int nbTours;
		
		public Environnement(Terrain terrain, int width, int height, int nbTours) {
			this.terrain = terrain;
			this.width = width;
			this.height = height;
			this.personnages = new ArrayList<>();
			this.nbTours = nbTours;
		}

		public int getWidth() {
			return width;
		}

		public int getHeight() {
			return height;
		}

		public ArrayList<Personnage> getPersonnages() {
			return personnages;
		}
		
		
}
