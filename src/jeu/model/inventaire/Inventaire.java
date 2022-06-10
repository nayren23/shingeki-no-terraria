package jeu.model.inventaire;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jeu.model.Environnement;
import jeu.model.inventaire.arme.Arme;
import jeu.model.inventaire.arme.Hand;
import jeu.model.inventaire.outil.Outil;
import jeu.model.inventaire.ressource.Bois;
import jeu.model.inventaire.ressource.Charbon;
import jeu.model.inventaire.ressource.Fer;
import jeu.model.inventaire.ressource.Gaz;
import jeu.model.inventaire.ressource.LiquideTitan;
import jeu.model.inventaire.ressource.Pain;
import jeu.model.inventaire.ressource.Ressource;
import jeu.model.inventaire.ressource.Terre;

public class Inventaire {

	private ObservableList<Objet> inventaire;
	private int stockageMax;
	private Environnement env;

	public Inventaire(Environnement env) {
		this.inventaire = FXCollections.observableArrayList();
		this.stockageMax = 20;
		this.env=env;
	}

	/**
	 * la fonction ajoute un objet dans l'inventaire 
	 * @param o correspond a l'objet envoyer en paramètre par stackRessource(Objet)
	 */
	public void ajouterDansInventaire (Objet o) {
		this.inventaire.add(o);
		System.out.println(this.inventaire);
	}

	/**
	 * lorsqu'un objet n'a plus de durabilite ou que le nombre est egal a zero, alors l'objet recu en parametre est retirer
	 * @param o correspond a l'objet envoyer en paramètre par faireDegatsBloc
	 */
	public void detruireObjet (Objet o) {
		Arme hand = new Hand();
		this.env.getEren().equiper(hand);
		this.inventaire.remove(o);
	}

	public void detruireRessource (Ressource r) {
		if(r instanceof Pain) {
			for (int i=0; i<this.inventaire.size(); i++) 
				if (this.inventaire.get(i).getIdObjet()==r.getIdObjet()) {
					this.inventaire.remove(i);
					System.out.println(this.inventaire);
				}
		}
		else if(r instanceof Fer) {
			for (int i=0; i<this.inventaire.size(); i++) 
				if (this.inventaire.get(i).getIdObjet()==r.getIdObjet()) {
					Fer fer = (Fer) this.inventaire.get(i);
					if (fer.getNbRessource()>1) {
						fer.decrementerRessource();
						this.inventaire.set(i, fer);
						System.out.println(this.inventaire);
					}
					else {
						this.inventaire.remove(i);
						System.out.println(this.inventaire);
					}
				}
		}
		else if(r instanceof Terre) {
			for (int i=0; i<this.inventaire.size(); i++) 
				if (this.inventaire.get(i).getIdObjet()==r.getIdObjet()) {
					Terre terre = (Terre) this.inventaire.get(i);
					if (terre.getNbRessource()>1) {
						terre.decrementerRessource();
						this.inventaire.set(i, terre);
						System.out.println(this.inventaire);
					}
					else {
						this.inventaire.remove(i);
						System.out.println(this.inventaire);
					}
				}
		}
		else if (r instanceof Gaz) {
			for (int i=0; i<this.inventaire.size(); i++) 
				if (this.inventaire.get(i).getIdObjet()==r.getIdObjet()) {
					Gaz gaz = (Gaz) this.inventaire.get(i);
					if (gaz.getNbRessource()>1) {
						gaz.decrementerRessource();
						this.inventaire.set(i, gaz);
						System.out.println(this.inventaire);
					}
					else {
						this.inventaire.remove(i);
						System.out.println(this.inventaire);
					}
				}
		}
		else if (r instanceof Charbon) {
			for (int i=0; i<this.inventaire.size(); i++) 
				if (this.inventaire.get(i).getIdObjet()==r.getIdObjet()) {
					Charbon charbon= (Charbon) this.inventaire.get(i);
					if (charbon.getNbRessource()>1) {
						charbon.decrementerRessource();
						this.inventaire.set(i, charbon);
						System.out.println(this.inventaire);
					}
					else {
						this.inventaire.remove(i);
						System.out.println(this.inventaire);
					}
				}
		}
		else if (r instanceof Bois) {
			for (int i=0; i<this.inventaire.size(); i++) 
				if (this.inventaire.get(i).getIdObjet()==r.getIdObjet()) {
					Bois bois = (Bois) this.inventaire.get(i);
					if (bois.getNbRessource()>1) {
						bois.decrementerRessource();
						this.inventaire.set(i, bois);
						System.out.println(this.inventaire);
					}
					else {
						this.inventaire.remove(i);
						System.out.println(this.inventaire);
					}
				}
		}
		else if (r instanceof LiquideTitan) {
			for (int i=0; i<this.inventaire.size(); i++) 
				if (this.inventaire.get(i).getIdObjet()==r.getIdObjet()) {
					this.inventaire.remove(i);
					System.out.println(this.inventaire);
				}
		}
	}

	//	public void detruireBloc(Ressource r) {
	//		int id = r.getIdObjet();
	//		this.inventaire.remove(id);
	//	}

	/**
	 * enleve resistance du bloc et durabilite de l'arme
	 * @param o est l'outil qui enleve de la resistance
	 * @param numeroTuile est la ressource qui perd de la resistance
	 */
	public void faireDegatsBloc(Outil o,  int numeroTuile) {
		//if (o.getIdObjet()==3)
		if (numeroTuile!=0)
			o.decrementerDurabiliteOutil(o);
		this.env.detruireBloc(env.getRessources().get(numeroTuile));
		if (o.getDurabilite()==0)
			detruireObjet(o);
	}

	/**
	 * une ressource peut avoir jusqu'a 200 d'elle meme dans le meme emplacement de l'inventaire, si la ressource n'existe pas encore, ajoute dans l'inventaire
	 * verifie si l'id de la ressource envoyer en parametre est deja presente dans l'inventaire, si oui, 
	 * parcours la liste et regarde lorsque les id de la ressource en parametre est egale a l'id de l'objet de l'inventaire et augmente le nombre de ressource
	 * @param r est la ressource qui va soit se stack soit s'ajouter dans l'inventaire
	 */
	public void stackRessource (Ressource r){
		if (existeDansInventaire(r.getIdObjet())){
			Ressource ressource;
			for (int i=0; i<this.inventaire.size(); i++) {
				if (r.getIdObjet()==this.inventaire.get(i).getIdObjet()) {
					ressource=(Ressource) this.inventaire.get(i);
					ressource.incrementerRessource();
					System.out.println(this.inventaire);
				}
			}
		}
		else
			ajouterDansInventaire(r);
	}

	/**
	 * verifie si l'id envoyer en parametre est deja dans la liste
	 * @param id est le parametre de l'objet
	 * @return renvoie true si l'id est deja dans l'inventaire, false si non
	 */
	public boolean existeDansInventaire (int id) {
		for(int i=0; i<this.inventaire.size(); i++) 
			if (this.inventaire.get(i).getIdObjet()==id)
				return true;

		return false;
	}

	/**
	 * creer la ressource puis appelle stackRessource en l'envoyant
	 * @param o est l'outil qui fait detruit le bloc
	 * @param numeroTuile est l'emplacement du bloc detruit
	 */
	public void creationBlocCasser (Outil o, int numeroTuile) {
		int cases=o.enleverResistanceBloc(numeroTuile);
		Terre terre = new Terre();

		switch (cases) {
		case 1:
			stackRessource(terre);
			break;

		case 2:
			stackRessource(terre);
			break;
		case 3:
			Charbon charbon = new Charbon();
			stackRessource(charbon);
			break;
		case 4:
			Gaz gaz = new Gaz();
			stackRessource(gaz);
			break;
		case 5:
			Fer fer = new Fer();
			stackRessource(fer);
			break;

		default:
			break;
		}
	}

	public boolean verifierPlace () {
		return this.inventaire.size()!=this.stockageMax;
	}

	public boolean verifierRessource (Ressource r) {
		for (int i=0; i<this.inventaire.size(); i++)
			if (this.inventaire.get(i).getIdObjet()==r.getIdObjet()) 
				return true;
		return false;
	}

	public ObservableList<Objet> getInventaire() {
		return inventaire;
	}
	
	public int getPositionObjet(Objet o) {
		for (int i=0; i<this.inventaire.size(); i++) {
			System.out.println(o.getIdObjet() + " yuichi " + this.inventaire.get(i));
			if (this.inventaire.get(i).getIdObjet()==o.getIdObjet()) {
				return i;
			}
		}
		return 0;
	}

	//	public int getPositionObjetSupprimer(Objet o) {
	//		Objet inv;
	//		for (int i=0; i<this.inventaire.size(); i++) {
	//			if (this.inventaire.contains(o))
	//				inv=o;
	//		}
	//		int position = inv.getIdObjet().
	//		detruireObjet(inv);
	//		return position;
	//	}

	@Override
	public String toString() {
		return "Vous avez dans votre inventaire = " + inventaire + " ]";
	}

}