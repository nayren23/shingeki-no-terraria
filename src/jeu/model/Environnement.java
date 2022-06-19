package jeu.model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jeu.Parametre;
import jeu.model.inventaire.Objet;
import jeu.model.inventaire.ressource.Bois;
import jeu.model.inventaire.ressource.Charbon;
import jeu.model.inventaire.ressource.Ciel;
import jeu.model.inventaire.ressource.Fer;
import jeu.model.inventaire.ressource.Gaz;
import jeu.model.inventaire.ressource.Ressource;
import jeu.model.inventaire.ressource.Terre;
import jeu.vue.PnjGentilVue;
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
	private Heros eren;
    private ObservableList<PnjMechantTitan> listeTitans;


	public Environnement() {
		this.terrain = new Terrain();
		this.width = 1280;
		this.height = 720;
		this.personnages = new ArrayList<>();
		this.eren = new Heros(0, 0, terrain, this);
		this.personnages.add(eren);
		this.ressources = new ArrayList<Ressource>();
        listeTitans = FXCollections.observableArrayList();

	}

	/**
	 * on creer la liste qui contient les 10 Titans
	 */
	public void creationListeTitans() {

		for (int i= 0 ; i< Parametre.nbTitansGenerer;i++) {
			int posX = 340 + (i *100 ) ;
			int posY = 480  ;

			listeTitans.add(new PnjMechantTitan(posX, posY, this, "titan" + i));
		}
	}

	public void creationRessources() {
		ressources.clear();
		terrain.affichertableau(terrain.getTabTerrain());
		System.out.println("terrain actuel" + terrain.getTerrainActuel() );
		for(int i=0 ;i<terrain.getTabTerrain().length;i++) {
			switch (terrain.getTabTerrain()[i]) {
			case 0:
				ressources.add(new Ciel());
				break;

			case 1:
				ressources.add(new Terre());
				break;
			
			case 2:
				ressources.add(new Terre());
				break;
				
			case 3:
				ressources.add(new Charbon());
				break;
				
			case 4:
				ressources.add(new Gaz());
				break;
				
			case 5:
				ressources.add(new Fer());
				break;
						
			case 6:
				ressources.add(new Bois());
				break;
				
			default:
				break;
			}
		}
	}
	
	public void detruireBloc (Ressource o) {
		o.enleverResistance(o);
	}
	
	public ArrayList<Ressource> getRessources() {
		return ressources;
	}
	
	public Ressource getObjet (int numeroTuile) {
		return getRessources().get(numeroTuile);
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
	
	

	public Heros getEren() {
		return eren;
	}

	public ArrayList<Personnage> getPersonnages() {
		return personnages;
	}


public ObservableList<PnjMechantTitan> getListeTitans() {
		return listeTitans;
	}
}