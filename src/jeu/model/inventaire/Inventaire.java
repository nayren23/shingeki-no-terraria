package jeu.model.inventaire;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jeu.model.Environnement;
import jeu.model.inventaire.arme.Arme;
import jeu.model.inventaire.outil.Outil;
import jeu.model.inventaire.ressource.Charbon;
import jeu.model.inventaire.ressource.Fer;
import jeu.model.inventaire.ressource.Gaz;
import jeu.model.inventaire.ressource.Ressource;
import jeu.model.inventaire.ressource.Terre;

public class Inventaire {

	private ObservableList<Objet> inventaire;
	private int stockageMax;
	private Environnement env;

	public Inventaire(Environnement env) {
		this.inventaire = FXCollections.observableArrayList();
		this.stockageMax = 20;
		this.env=env;
	}

	public void ajouterDansInventaire (Objet o) {
		this.inventaire.add(o);
		System.out.println(this.inventaire);
	}

	public void detruireObjet (Objet o) {
		this.inventaire.remove(o);
	}

	public void detruireBloc(Ressource r) {
		int id = r.getIdObjet();
		this.inventaire.remove(id);
	}

	//enleve resistance du bloc et durabilite de l'arme
	public void faireDegatsBloc(Outil o,  int numeroTuile) {
		o.decrementerDurabiliteOutil(o);
		this.env.detruireBloc(env.getRessources().get(numeroTuile));
		if (o.getDurabilite()==0)
			detruireObjet(o);
	}

	public void faireDegatsEnnemis(Arme a, Ressource r) {

	}

	//une ressource peut avoir jusqu'a 50 d'elle meme dans le meme emplacement de l'inventaire
	public void stackRessource (Ressource r){
		System.out.println("TEST 555");
		if (existeDansInventaire(r.getIdObjet())){
			Ressource ressource;
			for (int i=0; i<this.inventaire.size(); i++) {
				if (r.getIdObjet()==this.inventaire.get(i).getIdObjet()) {
					ressource=(Ressource) this.inventaire.get(i);
					if(ressource.getNbRessource() < ressource.getNbMax()) {
						ressource.incrementerRessource();
						System.out.println(this.inventaire);
					}				
				}
			}	
		}
		
		else
			ajouterDansInventaire(r);
	}
	
	public boolean existeDansInventaire (int id) {
		for(int i=0; i<this.inventaire.size(); i++) 
			if (this.inventaire.get(i).getIdObjet()==id)
				return true;
		
		return false;
	}

	public void creationBlocCasser (Outil o, int numeroTuile) {
		int cases=o.enleverResistanceBloc(numeroTuile);
		Terre terre = new Terre();


		switch (cases) {
		case 1:
			stackRessource(terre);
			break;

		case 2:
			stackRessource(terre);
			break;
		case 3:
			Charbon charbon = new Charbon();
			stackRessource(charbon);
			break;
		case 4:
			Gaz gaz = new Gaz();
			stackRessource(gaz);
			break;
		case 5:
			Fer fer = new Fer();
			stackRessource(fer);
			break;

		default:
			break;
		}
	}

	public boolean verifierPlace () {
		return this.inventaire.size()!=this.stockageMax;
	}

	public ObservableList<Objet> getInventaire() {
		return inventaire;
	}

	@Override
	public String toString() {
		return "Vous avez dans votre inventaire = " + inventaire + " ]";
	}

}