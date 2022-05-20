package jeu.model;

import java.util.ArrayList;

public class Environnement {
		//30*20
		private Terrain terrain;
		private int width, height;
		private ArrayList<Personnage> personnages;
		
		public Environnement() {
			this.terrain = new Terrain();
			this.width = 1280;
			this.height = 720;
			this.personnages = new ArrayList<>();
		}

		public int getWidth() {
			return width;
		}

		public int getHeight() {
			return height;
		}
		
		public Terrain getTerrain() {
			return this.terrain;
		}

		public ArrayList<Personnage> getPersonnages() {
			return personnages;
		}
		

		
}