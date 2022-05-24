package jeu.model.inventaire;

import java.util.ArrayList;

public class Inventaire {

	protected ArrayList<Objet> inventaire;
	private int stockageMax;

	public Inventaire() {
		this.inventaire = new ArrayList<>();
		this.stockageMax = 20;
	}

	public void ajouterDansInventaire (Objet o) {
		if (verifierPlace()==true)
			this.inventaire.add(o);
	}
	
	public boolean verifierPlace () {
		return this.inventaire.size()!=this.stockageMax;
	}

	public ArrayList<Objet> getInventaire() {
		return inventaire;
	}

}
