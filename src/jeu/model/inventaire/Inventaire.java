package jeu.model.inventaire;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventaire {

	private ObservableList<Objet> inventaire;
	private int stockageMax;

	public Inventaire() {
		this.inventaire = FXCollections.observableArrayList();
		this.stockageMax = 20;
	}

	public void ajouterDansInventaire (Objet o) {
		if (verifierPlace()==true) {
			this.inventaire.add(o);
		}
		else
			this.inventaire.remove(o);
	}
	
	public boolean verifierPlace () {
		return this.inventaire.size()!=this.stockageMax;
	}

	public ObservableList<Objet> getInventaire() {
		return inventaire;
	}

}