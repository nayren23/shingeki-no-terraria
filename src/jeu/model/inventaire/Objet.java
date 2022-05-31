package jeu.model.inventaire;

public abstract class Objet extends Inventaire{
	
	private int idObjet;
	private String nomObjet;

	public Objet(int id) {
		this.idObjet=id;
	}

	public int getIdObjet() {
		return idObjet;
	}

	public String getNomObjet() {
		return nomObjet;
	}

}
