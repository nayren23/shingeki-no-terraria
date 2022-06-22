package jeu.model.inventaire.outil;

import jeu.model.Environnement;
import jeu.model.inventaire.Objet;

public abstract class Outil extends Objet{
	
	private int durabilite;
	private String nom;
	private Environnement env;

	
	//durabilite est la durée de vie de l'outil, à chaque fois qu'il est utilise il perd 1 pv, il est donc possible de la baisser pour voir si elle se supprime

	public Outil(int id, String nom, Environnement env) {
		super(id);
		this.durabilite = 70;
		this.nom=nom;
		this.env = env;
	}
	
	public abstract int enleverResistanceBloc (int numeroTuilesCasser);
	
	public void decrementerDurabiliteOutil (Outil a) {
		this.durabilite=a.getDurabilite()-1;
	}
		
	public void nbDegats (int qualite) {
		if (qualite==1)
			setDegat(2);
		else if (qualite==2)
			setDegat(4);
		else 
			setDegat(8);
	}

	
	
/////////////////////Getters///////////////////////
	
	public int getDurabilite() {
		return durabilite;
	}

	public void setDegat(int degats) {
	}

	
	public Environnement getEnv() {
		return env;
	}

	
	@Override
	public String toString() {
		return "Nom de l'arme= " + nom;
	}

}
