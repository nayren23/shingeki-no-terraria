package jeu.model.inventaire;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jeu.model.Environnement;
import jeu.model.Terrain;
import jeu.model.inventaire.arme.Arme;
import jeu.model.inventaire.arme.Epee;
import jeu.model.inventaire.arme.Hand;
import jeu.model.inventaire.arme.LanceFoudroyante;
import jeu.model.inventaire.outil.Hache;
import jeu.model.inventaire.outil.Outil;
import jeu.model.inventaire.outil.Pelle;
import jeu.model.inventaire.outil.Pioche;
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
	 * la fonction ajoute un objet dans l'inventaire tant que la quantite max n'est pas atteinte
	 * @param o correspond a l'objet envoyer en param�tre par stackRessource(Objet)
	 */
	public void ajouterDansInventaire (Objet o) {
		if (verifierPlace()) {
			this.inventaire.add(o);
			System.out.println(this.inventaire);
		}
	}

	/**
	 * lorsqu'un objet n'a plus de durabilite ou que le nombre est egal a zero, alors l'objet recu en parametre est retirer
	 * @param o correspond a l'objet envoyer en param�tre par faireDegatsBloc
	 */
	public void detruireObjet (Objet o) {
		Arme hand = new Hand();
		this.env.getEren().equiper(hand);
		this.inventaire.remove(o);
	}

	public void detruireRessource (Ressource r) {
		for (int i=0; i<this.inventaire.size(); i++) {
			if (this.inventaire.get(i).getIdObjet()==r.getIdObjet()) {
				if(r instanceof Pain) {
					this.inventaire.remove(i);
					System.out.println(this.inventaire);

				}
				else if(r instanceof Fer) {
					Fer fer = (Fer) this.inventaire.get(i);
					if (fer.getNbRessource()>1) {
						fer.decrementerRessource(1);
						this.inventaire.set(i, fer);
						System.out.println(this.inventaire);
					}
					else {
						this.inventaire.remove(i);
						System.out.println(this.inventaire);
					}
				}
				else if(r instanceof Terre) {
					Terre terre = (Terre) this.inventaire.get(i);
					if (terre.getNbRessource()>1) {
						terre.decrementerRessource(1);
						this.inventaire.set(i, terre);
						System.out.println(this.inventaire);
					}
					else {
						this.inventaire.remove(i);
						System.out.println(this.inventaire);
					}
				}
				else if (r instanceof Gaz) {
					Gaz gaz = (Gaz) this.inventaire.get(i);
					if (gaz.getNbRessource()>1) {
						gaz.decrementerRessource(1);
						this.inventaire.set(i, gaz);
						System.out.println(this.inventaire);
					}
					else {
						this.inventaire.remove(i);
						System.out.println(this.inventaire);
					}		
				}
				else if (r instanceof Charbon) {
					Charbon charbon= (Charbon) this.inventaire.get(i);
					if (charbon.getNbRessource()>1) {
						charbon.decrementerRessource(1);
						this.inventaire.set(i, charbon);
						System.out.println(this.inventaire);
					}
					else {
						this.inventaire.remove(i);
						System.out.println(this.inventaire);
					}

				}
				else if (r instanceof Bois) {
					Bois bois = (Bois) this.inventaire.get(i);
					if (bois.getNbRessource()>1) {
						bois.decrementerRessource(1);
						this.inventaire.set(i, bois);
						System.out.println(this.inventaire);
					}
					else {
						this.inventaire.remove(i);
						System.out.println(this.inventaire);
					}

				}
				else if (r instanceof LiquideTitan) {
					this.inventaire.remove(i);
					System.out.println(this.inventaire);
				}
			}
		}
	}

	public boolean constructionErwin (Objet o, Ressource r, Fer f) {
		if (o instanceof Pelle) {
			if (existeDansInventaire(r.getIdObjet()) && existeDansInventaire(f.getIdObjet())) {
				int positionBois=positionRessourceDansListe(r);
				int positionFer=positionRessourceDansListe(f);
				if (possibilterConstruire((Ressource) this.inventaire.get(positionBois), 2) && possibilterConstruire((Ressource) this.inventaire.get(positionFer), 4)) {
					ajouterDansInventaire(o);
					((Ressource) this.inventaire.get(positionBois)).decrementerRessource(2);
					((Ressource) this.inventaire.get(positionFer)).decrementerRessource(4);
					if(positionBois<positionFer) {
						if (((Ressource) this.inventaire.get(positionBois)).getNbRessource()==0)
							this.inventaire.remove(positionBois);
						if (((Ressource) this.inventaire.get(positionFer-1)).getNbRessource()==0)
							this.inventaire.remove(positionFer-1);
						return true;
					}
					else {
						if (((Ressource) this.inventaire.get(positionFer)).getNbRessource()==0)
							this.inventaire.remove(positionFer);
						if (((Ressource) this.inventaire.get(positionBois-1)).getNbRessource()==0)
							this.inventaire.remove(positionBois-1);
						return true;
					}
				}
			}
		}
		if (o instanceof Pioche) {
			if (existeDansInventaire(r.getIdObjet()) && existeDansInventaire(f.getIdObjet())) {
				int positionBois=positionRessourceDansListe(r);
				int positionFer=positionRessourceDansListe(f);
				if (possibilterConstruire((Ressource) this.inventaire.get(positionBois), 3) && possibilterConstruire((Ressource) this.inventaire.get(positionFer), 5)) {
					ajouterDansInventaire(o);
					((Ressource) this.inventaire.get(positionBois)).decrementerRessource(3);
					((Ressource) this.inventaire.get(positionFer)).decrementerRessource(5);
					if(positionBois<positionFer) {
						if (((Ressource) this.inventaire.get(positionBois)).getNbRessource()==0)
							this.inventaire.remove(positionBois);
						if (((Ressource) this.inventaire.get(positionFer-1)).getNbRessource()==0)
							this.inventaire.remove(positionFer-1);
						return true;
					}
					else {
						if (((Ressource) this.inventaire.get(positionFer)).getNbRessource()==0)
							this.inventaire.remove(positionFer);
						if (((Ressource) this.inventaire.get(positionBois-1)).getNbRessource()==0)
							this.inventaire.remove(positionBois-1);
						return true;
					}
				}
			}
		}
		if (o instanceof Hache) {
			if (existeDansInventaire(r.getIdObjet()) && existeDansInventaire(f.getIdObjet())) {
				int positionBois=positionRessourceDansListe(r);
				int positionFer=positionRessourceDansListe(f);
				if (possibilterConstruire((Ressource) this.inventaire.get(positionBois), 4) && possibilterConstruire((Ressource) this.inventaire.get(positionFer), 6)) {
					ajouterDansInventaire(o);
					((Ressource) this.inventaire.get(positionBois)).decrementerRessource(4);
					((Ressource) this.inventaire.get(positionFer)).decrementerRessource(6);
					if(positionBois<positionFer) {
						if (((Ressource) this.inventaire.get(positionBois)).getNbRessource()==0)
							this.inventaire.remove(positionBois);
						if (((Ressource) this.inventaire.get(positionFer-1)).getNbRessource()==0)
							this.inventaire.remove(positionFer-1);
						return true;
					}
					else {
						if (((Ressource) this.inventaire.get(positionFer)).getNbRessource()==0)
							this.inventaire.remove(positionFer);
						if (((Ressource) this.inventaire.get(positionBois-1)).getNbRessource()==0)
							this.inventaire.remove(positionBois-1);
						return true;
					}
				}
			}
		}
		if (o instanceof Epee) {
			if (existeDansInventaire(r.getIdObjet()) && existeDansInventaire(f.getIdObjet())) {
				int positionBois=positionRessourceDansListe(r);
				int positionFer=positionRessourceDansListe(f);
				if (possibilterConstruire((Ressource) this.inventaire.get(positionBois), 1) && possibilterConstruire((Ressource) this.inventaire.get(positionFer), 10)) {
					ajouterDansInventaire(o);
					((Ressource) this.inventaire.get(positionBois)).decrementerRessource(1);
					((Ressource) this.inventaire.get(positionFer)).decrementerRessource(10);
					if(positionBois<positionFer) {
						if (((Ressource) this.inventaire.get(positionBois)).getNbRessource()==0)
							this.inventaire.remove(positionBois);
						if (((Ressource) this.inventaire.get(positionFer-1)).getNbRessource()==0)
							this.inventaire.remove(positionFer-1);
						return true;
					}
					else {
						if (((Ressource) this.inventaire.get(positionFer)).getNbRessource()==0)
							this.inventaire.remove(positionFer);
						if (((Ressource) this.inventaire.get(positionBois-1)).getNbRessource()==0)
							this.inventaire.remove(positionBois-1);
						return true;
					}
				}
			}
		}
		if (o instanceof LanceFoudroyante) {
			if (existeDansInventaire(r.getIdObjet()) && existeDansInventaire(f.getIdObjet())) {
				int positionGaz=positionRessourceDansListe(r);
				int positionFer=positionRessourceDansListe(f);
				if (possibilterConstruire((Ressource) this.inventaire.get(positionGaz), 1) && possibilterConstruire((Ressource) this.inventaire.get(positionFer), 10)) {
					ajouterDansInventaire(o);
					((Ressource) this.inventaire.get(positionGaz)).decrementerRessource(6);
					((Ressource) this.inventaire.get(positionFer)).decrementerRessource(15);
					if(positionGaz<positionFer) {
						if (((Ressource) this.inventaire.get(positionGaz)).getNbRessource()==0)
							this.inventaire.remove(positionGaz);
						if (((Ressource) this.inventaire.get(positionFer-1)).getNbRessource()==0)
							this.inventaire.remove(positionFer-1);
						return true;
					}
					else {
						if (((Ressource) this.inventaire.get(positionFer)).getNbRessource()==0)
							this.inventaire.remove(positionFer);
						if (((Ressource) this.inventaire.get(positionGaz-1)).getNbRessource()==0)
							this.inventaire.remove(positionGaz-1);
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean interactionArminSacha (Ressource r) {
		for (int i=0; i<this.inventaire.size(); i++) {
			if (this.inventaire.get(i).getIdObjet()==r.getIdObjet()) {
				if (r instanceof Bois) {
					if (existeDansInventaire(r.getIdObjet())) {
						if(possibilterConstruire((Ressource)this.inventaire.get(i), 50)) {
							((Ressource) this.inventaire.get(i)).decrementerRessource(50);
							if (((Ressource) this.inventaire.get(i)).getNbRessource()==0)
								this.inventaire.remove(i);
							return true;
						}
					}
				}
				else if (r instanceof Terre) {
					if (existeDansInventaire(r.getIdObjet())) {
						if(possibilterConstruire((Ressource)this.inventaire.get(i), 2)) {
							((Ressource) this.inventaire.get(i)).decrementerRessource(2);
							if (((Ressource) this.inventaire.get(i)).getNbRessource()==0)
								this.inventaire.remove(i);
							Pain pain = new Pain();
							if (existeDansInventaire(pain.getIdObjet())) {
								int positionPain = positionRessourceDansListe(pain);
								((Ressource)this.inventaire.get(positionPain)).incrementerRessource();
								System.out.println(this.inventaire.get(positionPain));
							}
							else
								this.inventaire.add(pain);

							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public int positionRessourceDansListe(Ressource r) {
		for (int i=0; i<this.inventaire.size(); i++)
			if(this.inventaire.get(i).getIdObjet()==r.getIdObjet())
				return i;
		return -1;
	}

	public int differenceRessourcesManquantes (int ressourcesInventaire, int quantiteNecessaire) {
		return quantiteNecessaire-ressourcesInventaire;
	}

	public boolean possibilterConstruire (Ressource r, int quantiteNecessaireRessource) {
		if (r.getNbRessource()>=quantiteNecessaireRessource) 
			return true;

		return false;
	}

	//	public void detruireBloc(Ressource r) {
	//		int id = r.getIdObjet();
	//		this.inventaire.remove(id);
	//	}

	/**
	 * enleve resistance du bloc et durabilite de l'arme
	 * @param o est l'outil qui enleve de la resistance
	 * @param numeroTuile est la ressource qui perd de la resistance
	 * @param t est le terrain
	 */
	public void faireDegatsBloc(Outil o,  int numeroTuile, Terrain t) {
		//if (o.getIdObjet()==3)
		if(o instanceof Pelle) {
			if (t.getTabTerrain()[numeroTuile]!=0 && t.getTabTerrain()[numeroTuile]!=3 && t.getTabTerrain()[numeroTuile]!=4 && t.getTabTerrain()[numeroTuile]!=5 && t.getTabTerrain()[numeroTuile]!=6)
				o.decrementerDurabiliteOutil(o);
		}
		else if(o instanceof Hache) {
			if (t.getTabTerrain()[numeroTuile]!=0 && t.getTabTerrain()[numeroTuile]!=1 && t.getTabTerrain()[numeroTuile]!=2 && t.getTabTerrain()[numeroTuile]!=3 && t.getTabTerrain()[numeroTuile]!=4 && t.getTabTerrain()[numeroTuile]!=5)
				o.decrementerDurabiliteOutil(o);
		}
		else if(o instanceof Pioche) {
			if (t.getTabTerrain()[numeroTuile]!=0 && t.getTabTerrain()[numeroTuile]!=1 && t.getTabTerrain()[numeroTuile]!=2 && t.getTabTerrain()[numeroTuile]!=6)
				o.decrementerDurabiliteOutil(o);
		}
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