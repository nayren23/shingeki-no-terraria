package jeu.model.inventaire;

public abstract class Objet{
	
	private int idObjet;

	public Objet(int id) {
		this.idObjet=id;
	}

	public int getIdObjet() {
		return idObjet;
	}

	@Override
	public String toString() {
		return "idObjet=" + idObjet + "";
	}

}
