package jeu.model;

import java.util.ArrayList;

import jeu.Parametre;
import jeu.model.inventaire.Objet;
import jeu.model.inventaire.ressource.Charbon;
import jeu.model.inventaire.ressource.Ciel;
import jeu.model.inventaire.ressource.Fer;
import jeu.model.inventaire.ressource.Gaz;
import jeu.model.inventaire.ressource.Ressource;
import jeu.model.inventaire.ressource.Terre;

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
	private ArrayList<PnjMechantTitan> listeTitans;
	private Heros eren;
	//private PnjMechantTitan titans ;

	public Environnement() {
		this.terrain = new Terrain();
		this.width = 1280;
		this.height = 720;
		this.personnages = new ArrayList<>();
		this.eren = new Heros(0, 0, terrain, this);
		this.personnages.add(eren);
		listeTitans = new ArrayList<PnjMechantTitan>();

		creationListeTitans();
		this.ressources = new ArrayList<Ressource>();
		creationRessources();
	}

	/**
	 * on creer la liste qui contient les 10 Titans
	 */
	public void creationListeTitans() {

		for (int i= 0 ; i< Parametre.nbTitansGenerer;i++) {
			int posX = 500 +i *100  ;
			int posY = 450  ;

			listeTitans.add(new PnjMechantTitan(posX, posY, this, "titan" + i));
		}
		System.out.println("\n AffichagelisteTitans " + listeTitans);
	}

	public void creationRessources() {
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

			default:
				break;
			}
		}
	}

	//	public void creationTitans () {
	////		for(int i=0 ;i<titans.length;i++) {
	//			new PnjMechantTitan(10, 10, this.getTerrain(), this);
	////		}
	//	}


	public void detruireBloc (Ressource o) {
		o.enleverResistance(o);
		//		if (r.getResistance()<=0) 
		//			eren.getInventaireHeros().stackRessource(r); Pas utilile car stack ressources dej appeller 
	}

	//	public PnjMechantTitan getTitans() {
	//		return titans;
	//	}

	public ArrayList<PnjMechantTitan> getListeTitans() {
		return listeTitans;
	}

	public void setListeTitans(ArrayList<PnjMechantTitan> listeTitans) {
		this.listeTitans = listeTitans;
	}

	public ArrayList<Ressource> getRessources() {
		return ressources;
	}

	public Ressource getObjet (int numeroTuile) {
		Ressource r = getRessources().get(numeroTuile);
		System.out.println("\n c'est moi wsh" + r);
		return getRessources().get(numeroTuile);
	}


	//	public PnjMechantTitan[] getTitans() {
	//		return titans;
	//	}
	//
	//	public void setTitans(PnjMechantTitan[] titans) {
	//		this.titans = titans;
	//	}

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

}