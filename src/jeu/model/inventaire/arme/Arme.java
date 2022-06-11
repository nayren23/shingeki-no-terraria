package jeu.model.inventaire.arme;

import jeu.model.inventaire.Objet;

public abstract class Arme extends Objet{
	
	private int durabilite;
	private int degats;
	private int qualite;
	private String nom;
	
	public Arme (int id, String nom) {
		super(id);
		this.durabilite = 100;
		this.degats = 100;
		this.nom=nom;
	}
	
	public void nbDegats (int qualite) {
		if (qualite==1)
			setDegat(2);
		else if (qualite==2)
			setDegat(4);
		else 
			setDegat(8);
	}
	
	public void decrementerDurabiliteArme (Arme a) {
		this.durabilite-=1;
	}

	public void setDegat(int degat) {
		this.degats = degat;
	}

	public int getDurabilite() {
		return durabilite;
	}

	@Override
	public String toString() {
		return "Nom de l'arme= " + nom;
	}

	public int getDegats() {
		return degats;
	}
	

}