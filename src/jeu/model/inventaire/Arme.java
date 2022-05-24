package jeu.model.inventaire;

import java.util.ArrayList;

public class Arme extends Objet{
	
	private int durabilité;
	private int dégat;
	private int qualité;
	private String nomArme;
	
	public Arme(int id, ArrayList<Objet> o, int x, int y, String nom) {
		super(id, o, x, y);
		this.durabilité=100;
		this.dégat=2;
		this.nomArme=nom;
	}
	
	public void faireDegats() {
		this.durabilité-=1;
		if (this.durabilité==0)
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
		this.dégat = dégat;
	}

}
