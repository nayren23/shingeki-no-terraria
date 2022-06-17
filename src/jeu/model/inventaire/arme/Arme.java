package jeu.model.inventaire.arme;

import jeu.model.inventaire.Objet;

public abstract class Arme extends Objet{
	
	private int durabilite;
	private int degats;
	private int qualite;
	private String nom;
	
	//durabilite est la durée de vie de l'arme, à chaque fois qu'il est utilise il perd 1 pv, il est donc possible de la baisser pour voir si elle se supprime
	public Arme (int id, String nom) {
		super(id);
		this.durabilite = 10;
		this.degats = 10;  /// canger en fonction de la vie 
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