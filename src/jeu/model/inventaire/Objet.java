package jeu.model.inventaire;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Objet extends Inventaire{
	
	private ArrayList<Objet> objets;
	private int idObjet;
	IntegerProperty xProp,yProp;

	public Objet(int idObjet, ArrayList<Objet> o, int x, int y) {
		this.xProp = new SimpleIntegerProperty(x);
		this.yProp = new SimpleIntegerProperty(y);
		this.idObjet = idObjet;
	}
	
	public int getIdObjet() {
		return idObjet;
	}

}
