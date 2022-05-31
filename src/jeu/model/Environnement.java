package jeu.model;

import java.util.ArrayList;

import jeu.model.inventaire.ressource.Charbon;
import jeu.model.inventaire.ressource.Fer;
import jeu.model.inventaire.ressource.Gaz;
import jeu.model.inventaire.ressource.Ressource;
import jeu.model.inventaire.ressource.Terre;

public class Environnement {
	//30*20
	private Terrain terrain;
	private int width, height;
	private ArrayList<Personnage> personnages;
	private ArrayList<Ressource> ressources;

	public Environnement() {
		this.terrain = new Terrain();
		this.width = 1280;
		this.height = 720;
		this.personnages = new ArrayList<>();
		this.ressources = new ArrayList<Ressource>();
		creationRessources();
	}

	public void creationRessources() {

		for(int i=0 ;i<terrain.getTerrain().length;i++) {
			switch (terrain.getTerrain()[i]) {
			case 0:
				ressources.add(new Gaz());

				break;

			case 1:
				ressources.add(new Terre());
				break;
			
			case 2:
				ressources.add(new Terre());
				break;
				
			case 3:
				ressources.add(new Terre());
				break;
				
			case 4:
				ressources.add(new Terre());
				break;
				
			case 5:
				ressources.add(new Fer());
				break;
			
			case 6:
				ressources.add(new Charbon());
				break;
				
			default:
				break;
			}
		}
	}

	
	public ArrayList<Ressource> getRessources() {
		return ressources;
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