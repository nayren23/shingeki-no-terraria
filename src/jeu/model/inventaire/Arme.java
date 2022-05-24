package jeu.model.inventaire;

import java.util.ArrayList;

public class Arme extends Objet{
	
	private int durabilite;
	private int degats;
	private int qualite;
	private String nomArme;
	
	public Arme(int id, ArrayList<Objet> o, int x, int y, String nom) {
		super(id, o, x, y);
		this.durabilite=100;
		this.degats=2;
		this.nomArme=nom;
	}
	
	public void faireDegats() {
		this.durabilite-=1;
		if (this.durabilite==0)
			super.inventaire.remove(getIdObjet());
	}
	
	public void nbDegats (int qualite) {
		if (qualite==1)
			setDégat(1);
		else if (qualite==2)
			setDégat(2);
		else 
			setDégat(3);
	}

	public void setDégat(int dégat) {
		this.degats = dégat;
	}

}