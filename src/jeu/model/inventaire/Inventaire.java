package jeu.model.inventaire;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jeu.model.Environnement;
import jeu.model.inventaire.arme.Arme;
import jeu.model.inventaire.ressource.Ressource;

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
	
	public void detruireArme (Objet o) {
		this.inventaire.remove(o);
	}
	
	public void detruireBloc(Ressource r) {
		int id = r.getIdObjet();
		this.inventaire.remove(id);
	}
	
	public void faireDegats(Arme a, Ressource r) {
		this.env.enleverResistance(r);
		int durabilite = a.getDurabilite()-1;
		if (durabilite==0)
			detruireArme(a);
	}
	
	//une ressource peut avoir jusqu'a 50 d'elle meme dans le meme emplacement de l'inventaire
	public void stackRessource (Ressource r){
		if (this.inventaire.contains(r)) {
			boolean test=false;
			Ressource ressource;
			for (int i=0; i<this.inventaire.size() && !test; i++) 
				if (this.inventaire.get(i)==r ) {
					ressource=(Ressource) this.inventaire.get(i);
					if(ressource.getNbRessource() < ressource.getNbMax()) {
						ressource.incrementerRessource();
						System.out.println(this.inventaire);
					}
					else {
						ajouterDansInventaire(r);
						test=true;
					}
					
				}
		}
		else
			ajouterDansInventaire(r);
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