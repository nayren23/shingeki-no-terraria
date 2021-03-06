package jeu.controleur;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import jeu.Parametre;
import jeu.model.Environnement;
import jeu.model.inventaire.Objet;
import jeu.model.inventaire.arme.LanceFoudroyante;
import jeu.model.inventaire.arme.Hand;
import jeu.model.inventaire.outil.Hache;
import jeu.model.inventaire.outil.Outil;
import jeu.model.inventaire.outil.Pelle;
import jeu.model.inventaire.outil.Pioche;
import jeu.model.inventaire.ressource.Bois;
import jeu.model.inventaire.ressource.Charbon;
import jeu.model.inventaire.ressource.Fer;
import jeu.model.inventaire.ressource.Gaz;
import jeu.model.inventaire.ressource.Pain;
import jeu.model.inventaire.ressource.Ressource;
import jeu.model.inventaire.ressource.Terre;
import jeu.vue.TerrainVue;

public class MouseClick implements EventHandler<MouseEvent> {


	private Environnement env;
	private TerrainVue terrainVue;

	public static int tailleTuile = 32;
	public static int tailleMapLongueur = 40;  // nombre de tuiles dans une ligne

	public MouseClick(Environnement env ,TerrainVue terrainVue) {
		this.env = env;
		this.terrainVue = terrainVue;
	}

	@Override
	/**
	 * Methodes utiliser pour connaitre les coordonner de d une tuile lorsqu on clique sur la souris
	 */
	public void handle(MouseEvent arg0) {

		// Pour connaitre la position d une tuile on divise notre taille par la taille de notre tuile
		int x = (int)arg0.getX()/tailleTuile;
		int y = (int)arg0.getY()/tailleTuile;
		int positionTuileDansTableau = (y * tailleMapLongueur  ) + x;

		Objet objet = this.env.getEren().getObjetHeros();
		int xCase = (int)arg0.getX();
		int yCase = (int)arg0.getY();
		//en fonction de l objet equipe ont fait differentes action creuser ou poser un bloc
	
		//si pas mort alors peut faire action de la souris
		if(!env.getEren().estMort()) {


			if (Parametre.rangePourCasserBloc(env.getEren().getX(), env.getEren().getY(), xCase ,yCase, 30*2, 47*2 , 25*2, 64*2)) {

				if (objet instanceof Pioche && arg0.getButton() == MouseButton.PRIMARY  ) {
					env.getEren().getInventaireHeros().faireDegatsBloc((Outil) objet, positionTuileDansTableau, env.getTerrain());
					env.getEren().getInventaireHeros().creationBlocCasser((Outil) objet , positionTuileDansTableau);
					terrainVue.changementTuileMinage(positionTuileDansTableau,env.getTerrain(),Parametre.changementDuBlocCasser);
				}

				else if(objet instanceof Pelle && arg0.getButton() == MouseButton.PRIMARY) {
					env.getEren().getInventaireHeros().faireDegatsBloc((Outil) objet, positionTuileDansTableau, env.getTerrain());
					env.getEren().getInventaireHeros().creationBlocCasser((Outil) objet , positionTuileDansTableau);
					terrainVue.changementTuileMinage(positionTuileDansTableau,env.getTerrain(),Parametre.changementDuBlocCasser);
				}
				else if(objet instanceof Hache && arg0.getButton() == MouseButton.PRIMARY) {
					env.getEren().getInventaireHeros().faireDegatsBloc((Outil) objet, positionTuileDansTableau, env.getTerrain());
					env.getEren().getInventaireHeros().creationBlocCasser((Outil) objet , positionTuileDansTableau);// changer et faire une fonction qui actualise juste l'image chang???
					terrainVue.changementTuileMinage(positionTuileDansTableau,env.getTerrain(),Parametre.changementDuBlocCasser);// changer et faire une fonction qui actualise juste l'image chang???			}

				}

				else if(objet instanceof Terre && arg0.getButton() == MouseButton.SECONDARY) {
					Terre terre = new Terre();
					if(this.env.getEren().getInventaireHeros().verifierRessource(terre)) {
						if(((Terre) objet).poserBloc(positionTuileDansTableau, env.getTerrain(),Parametre.blocTerre)) {
							terrainVue.changementTuileMinage(positionTuileDansTableau,env.getTerrain(),Parametre.blocTerre);

							// Inventaire
							env.getRessources().set(positionTuileDansTableau, terre);
							env.getEren().getInventaireHeros().detruireRessource(terre);
						}

					}
				}

				else if(objet instanceof Fer && arg0.getButton() == MouseButton.SECONDARY) {
					Fer fer = new Fer();
					if(this.env.getEren().getInventaireHeros().verifierRessource(fer)) {
						if(((Fer) objet).poserBloc(positionTuileDansTableau, env.getTerrain(),Parametre.blocFer)) {
							terrainVue.changementTuileMinage(positionTuileDansTableau,env.getTerrain(),Parametre.blocFer);

							// Inventaire
							env.getRessources().set(positionTuileDansTableau, fer);
							env.getEren().getInventaireHeros().detruireRessource(fer);
						}
	
					}
				}

				else if(objet instanceof Charbon && arg0.getButton() == MouseButton.SECONDARY) {
					Charbon charbon = new Charbon();
					if(this.env.getEren().getInventaireHeros().verifierRessource(charbon)) {
						if(((Charbon) objet).poserBloc(positionTuileDansTableau, env.getTerrain(),Parametre.blocCharbon)) {
							terrainVue.changementTuileMinage(positionTuileDansTableau,env.getTerrain(),Parametre.blocCharbon);

							// Inventaire
							env.getRessources().set(positionTuileDansTableau, charbon);
							env.getEren().getInventaireHeros().detruireRessource(charbon);
						}

					}
				}

				else if(objet instanceof Gaz && arg0.getButton() == MouseButton.SECONDARY) {
					Gaz gaz = new Gaz();
					if(this.env.getEren().getInventaireHeros().verifierRessource(gaz)) {
						if(((Gaz) objet).poserBloc(positionTuileDansTableau, env.getTerrain(),Parametre.blocGaz)) {
							terrainVue.changementTuileMinage(positionTuileDansTableau,env.getTerrain(),Parametre.blocGaz);

							// Inventaire
							env.getRessources().set(positionTuileDansTableau, gaz);
							env.getEren().getInventaireHeros().detruireRessource(gaz);
						}

					}
				}
				
				else if(objet instanceof Bois && arg0.getButton() == MouseButton.SECONDARY) {
					Bois bois = new Bois();
					if(this.env.getEren().getInventaireHeros().verifierRessource(bois)) {
						if(((Bois) objet).poserBloc(positionTuileDansTableau, env.getTerrain(),Parametre.blocBois)) {
							terrainVue.changementTuileMinage(positionTuileDansTableau,env.getTerrain(),Parametre.blocBois);

							// Inventaire
							env.getRessources().set(positionTuileDansTableau, bois);
							env.getEren().getInventaireHeros().detruireRessource(bois);
						}
					}
				}
			}
			else if(objet instanceof Pain) {
				Pain pain = new Pain();
				env.getEren().augmenterPv(pain);
				if(this.env.getEren().getInventaireHeros().existeDansInventaire(pain.getIdObjet())) {
					int positionPain = this.env.getEren().getInventaireHeros().positionRessourceDansListe(pain);
					if( ((Ressource)this.env.getEren().getInventaireHeros().getInventaire().get(positionPain)).getNbRessource()>1) {
						((Ressource) this.env.getEren().getInventaireHeros().getInventaire().get(positionPain)).decrementerRessource(positionPain);
						Hand hand = new Hand();
						this.env.getEren().equiper(hand);
					}
					else
						env.getEren().getInventaireHeros().detruireRessource(pain);
				}
			}
			else if(objet instanceof LanceFoudroyante ) {
				LanceFoudroyante arme = (LanceFoudroyante) objet;
				arme.setLanceAvance(true);
			}

		}


	}
}