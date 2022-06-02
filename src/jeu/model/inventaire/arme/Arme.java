package jeu.model.inventaire.arme;

import jeu.model.inventaire.Objet;
import jeu.model.inventaire.ressource.Ressource;

public abstract class Arme extends Objet{
	
	private int durabilite;
	private int degats;
	private int qualite;
	
	public Arme (int id) {
		super(id);
		this.durabilite = 100;
		this.degats = 2;
	}

	public void faireDegats(Arme a, Ressource r) {
		r.enleverResistance(a);
		this.durabilite-=1;
		if (this.durabilite==0)
			detruireArme(a);
	}
	
	public void detruireArme (Objet o) {
		super.getInventaire().remove(o);
	}
	
	public void nbDegats (int qualite) {
		if (qualite==1)
			setDegat(2);
		else if (qualite==2)
			setDegat(4);
		else 
			setDegat(8);
	}

	public void setDegat(int degat) {
		this.degats = degat;
	}

}